package lesson9data

class MessageService() : CrudInterface<Message> {
    private var messages = ArrayList<Message>()

    override fun create(entity: Message): Boolean {
        val id = messages.size + 1
        val chatId = entity.chatId
        messages.add(entity.copy(id = id, chatId = chatId))
        return true
    }

    override fun read(): List<Message> {
        return messages.filter { !it.deleted && !it.readed }
    }

    override fun update(entity: Message): Boolean {
        val message = entity.copy(text = entity.text)
        messages.remove(entity)
        messages.add(message)
        return true
    }

    override fun delete(id: Int) {
        val message = messages.filter { id == id }[0]
        message.deleted = true
    }

    fun restore(id: Int) {
        messages.filter { id == id }[0].deleted = false
    }

    fun read(chatId: Int, lastMessageId: Int, messCount: Int): List<Message> {
        return when (messCount) {
            0 -> messages.asSequence()
                .filter { it.chatId == chatId }
                .filter { it.id >= lastMessageId }
                .toList()
            else -> messages.asSequence()
                .filter { it.chatId == chatId }
                .filter { it.id >= lastMessageId }
                .take(messCount)
                .toList()
        }
    }

    fun markReaded(id: Int) {
        messages.filter { it.id == id }[0].readed = true
    }

    fun markReaded(chatId: Int, lastMessageId: Int, messCount: Int) {
        read(chatId, lastMessageId, messCount).asSequence()
            .map { m -> m.apply { markReaded(m.id) } }
            .toList()
    }

    fun deleteAll(chatId: Int) {
        messages.asSequence()
            .filter { c -> c.chatId == chatId }
            .map { c -> c.apply { deleted = true } }
            .toList()
    }
}