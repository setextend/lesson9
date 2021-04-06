package lesson9data

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MessageServiceTest {

    @Test
    fun crudChatService() {
        //arrange
        var myChat = ChatService()
        val chat = Chat(1, 1, arrayOf(1 , 2))
        val myMessage1 = Message(1,1,1,"message1",2)
        val myMessage2 = Message(2,1,2,"message2",1)
        val myMessage3 = Message(3,1,1,"message3",2)
        val myMessage4 = Message(4,1,2,"message4",1)

        //act
        val resultCreate = myChat.create(chat)
        val resultCreateMessage = myChat.messages.create(myMessage1)
        myChat.messages.create(myMessage2)
        myChat.messages.create(myMessage3)
        myChat.messages.create(myMessage4)
        val resultRead = myChat.messages.read()
        val resultUpdate = myChat.messages.update(myMessage2)
        myChat.messages.delete(1)
        val resultReadMes = myChat.read(1,2,1)
        myChat.messages.deleteAll(1)

        //assert
        assertEquals(true, resultCreate)
        assertNotNull(resultRead)
        assertEquals(true,resultUpdate)
        assertNotNull(resultReadMes)
    }
}