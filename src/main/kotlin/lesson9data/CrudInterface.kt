package lesson9data

interface CrudInterface<E>{
    fun create(entity: E): Boolean
    fun read(): List<E>
    fun update(entity: E): Boolean
    fun delete(id: Int)
}