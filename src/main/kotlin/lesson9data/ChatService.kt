package lesson9data

class ChatService() : CrudInterface<Chat> {
    private var chatMass = ArrayList<Chat>()
    val messages = MessageService()

    override fun create(entity: Chat): Boolean {
        val id = chatMass.size + 1
        chatMass.add(entity.copy(userId = id))
        return true
    }

    override fun read(): List<Chat> {
        return chatMass.filter { !it.deleted }
    }

    override fun update(entity: Chat): Boolean {
        chatMass.remove(readById(entity.id))
        chatMass.add(entity.copy())
        return true
    }

    override fun delete(id: Int) {
        chatMass.filter { it.id == id }[0].deleted = true
    }


    fun readById(id: Int): Chat {
        return chatMass.filter { it.id == id }[0]
    }

    fun restore(id: Int) {
        chatMass.filter { it.id == id }[0].deleted = false
    }

    fun getUnreadChatsCount(userId: Int): Int {
        return chatMass.count { chat -> messages.read(chat.id, 0, 0).any { (it.userId == userId) && !it.deleted && !it.readed  }}
    }

    fun getChats(userId: Int): Int {
        return chatMass.count { chat -> messages.read(chat.id, 0, 0).any { (it.userId == userId) }}
    }

    fun read(chatId: Int, lastMessageId: Int, messCount: Int): List<Message> {
        messages.markReaded(chatId, lastMessageId, messCount)
        return messages.read(chatId, lastMessageId, messCount)
    }

}
