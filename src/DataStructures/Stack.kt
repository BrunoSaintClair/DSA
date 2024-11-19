package DataStructures

// LIFO | Last In First Out

class Stack<T> {
    private var length: Int = 0
    private var head: Node<T>? = null

    fun push(value: T) {
        val newNode = Node(value)
        length++

        if (head == null) {
            head = newNode
            newNode.previous = null
            return
        }

        val old_head = head
        head = newNode
        head?.previous = old_head
        return
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }

        val old_head = head
        head = old_head?.previous

        length--
        return old_head!!.value
    }

    fun peek(): T? { return head?.value }

    fun size(): Int { return length }

    fun isEmpty(): Boolean { return length == 0 }
}