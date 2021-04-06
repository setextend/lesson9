package lesson9data

data class Message(
    val id: Int,
    val chatId: Int,
    val userId: Int,
    val text: String,
    val toUserId: Int
){
    var readed: Boolean = false
    var deleted:Boolean = false
}
