package DataStructures

// FIFO | First In First Out

class Queue<T> {
    private var length: Int = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun enqueue(item: T){
        val newNode = Node(item)
        if (tail == null){
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            tail = newNode
        }
        length++
    }

    fun dequeue(): T? {
        if (head == null){
            return null
        }

        val old_head = head
        head = head?.next

        old_head!!.next = null


        if (length == 0){
            head = null
            tail = null
        }

        length--
        return old_head.value
    }

    fun peek(): T? { return head?.value }

    fun size(): Int { return length }

    fun isEmpty(): Boolean { return length == 0 }
}