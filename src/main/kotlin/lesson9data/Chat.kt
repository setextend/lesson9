package lesson9data

data class Chat(
    val id: Int,
    val userId: Int,
    val members: Array<Int>
) {
    var deleted: Boolean = false
}
