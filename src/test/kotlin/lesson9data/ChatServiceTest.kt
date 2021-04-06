package lesson9data

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ChatServiceTest {

    @Test
    fun crudChatService() {
        //arrange
        var myChat = ChatService()
        val chat = Chat(1, 1, arrayOf(1 , 2))

        //act
        val resultCreate = myChat.create(chat)
        val resultRead = myChat.read()
        val resultUpdate = myChat.update(chat)
        myChat.delete(1)
        val resultgetUnreadChatsCount = myChat.getUnreadChatsCount(1)
        val resultReadMes = myChat.read(1,2,1)

        //assert
        assertEquals(true, resultCreate)
        assertNotNull(resultRead)
        assertEquals(true,resultUpdate)
        assertNotNull(resultgetUnreadChatsCount)
        assertNotNull(resultReadMes)
    }
}