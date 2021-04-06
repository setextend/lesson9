package lesson9data

fun main(args: Array<String>){
    val chat = Chat(1,1,arrayOf(1, 2, 3))
    val myChat = ChatService()
    val resultCreate = myChat.create(chat)
    myChat.create(chat)
    myChat.create(chat)
    println(myChat.read())
    println(myChat.readById(2))
    println(myChat.readById(2).deleted)
    myChat.delete(2)
    println(myChat.readById(2).deleted)
    myChat.restore(2)
    println(myChat.readById(2).deleted)

    myChat.messages.create(Message(1,1,1,"message1",2))
    myChat.messages.create(Message(1,2,1,"message2",2))
    myChat.messages.create(Message(1,2,2,"message3",1))
    myChat.messages.create(Message(1,1,2,"message4",1))
    myChat.messages.create(Message(1,1,1,"message5",2))

    println(myChat.messages.read())
    println(myChat.messages.read(2,1,0))
    myChat.messages.markReaded(2,1,0)
    println(myChat.messages.read())
}