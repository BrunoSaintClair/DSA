package DataStructures

class SinglyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun get(index: Int): T? {
        if (index < 0 || index >= size) {
            return null
        }
        var current = head

        for (i in 0 until index) {
            current = current!!.next
        }

        return current?.value
    }


    fun isEmpty(): Boolean = size == 0


}
class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    fun get(index: Int): T? {
        if (index < 0 || index >= size) {
            return null
        }
        var current = head

        for (i in 0 until index) {
            current = current!!.next
        }

        return current?.value
    }

    fun isEmpty(): Boolean = size == 0

}

/*
OPERAÇÕES:
    - add no inicio, no fim, e em posição específica
    - delete no inicio, no fim, e em posição específica
    - retornar tamanho
    - buscar nó por valor
    - buscar um nó específico e alterar o valor dele
    - inverter
 */

/* Não possui índice
   Para adicionar ou excluir elementos vc tem q gerenciar os "next" e os "previous" em volta */
