package DataStructures

open class LinkedList<T> {
	var head: Node<T>? = null
	var tail: Node<T>? = null
	var length: Int = 0

	fun isEmpty(): Boolean = length == 0
	fun getSize(): Int = length

	fun get(index: Int): T? {
		if (index < 0 || index >= length) {
			throw IndexOutOfBoundsException()
		}

		var current = head
		for (i in 0 until index) {
			current = current?.next
		}

		return current?.value
	}

	open fun prepend(item: T) { // Adicionar no início
		val newNode = Node(item)

		if (head == null) {
			head = newNode
			tail = newNode
		} else {
			newNode.next = head
			head = newNode
		}

		length++
	}

	open fun append(item: T) { // Adicionar no fim
		val newNode = Node(item)

		if (head == null) {
			head = newNode
			tail = newNode
		} else {
			tail!!.next = newNode
			tail = newNode
		}

		length ++
	}

	open fun insertAt(index: Int, item: T) {
		if (index < 0 || index > length) {
			throw IndexOutOfBoundsException()
		} else if (index == length) {
			this.append(item)
		} else if (index == 0) {
			this.prepend(item)
		} else {
			var current = head
			for (i in 0 until index - 1) {
				current = current !!.next
			}

			val newNode = Node(item)
			newNode.next = current !!.next
			current.next = newNode

			if (newNode.next == null) {
				tail = newNode
			}

			length ++
		}
	}

	open fun revert(): Node<T>?{
		var new_list: Node<T>? = null
		tail = head

		while (head != null) {
			val next_node = head?.next
			head?.next = new_list
			new_list = head
			head = next_node
		}

		head = new_list
		return head
	}

	fun deleteHead(): T? {    // O(1)
		if (head == null){
			return null
		}

		val old_head_value = head!!.value
		head = head!!.next

		length--
		return old_head_value
	}

	open fun deleteTail(): T? {
		if (tail == null){
			return null
		}

		if (head == tail) {
			val oldTailValue = tail?.value
			head = null
			tail = null
			length--
			return oldTailValue
		}

		var curr = head
		while (curr?.next != tail) {
			curr = curr!!.next
		}

		val old_tail = tail
		curr?.next = null
		tail = curr

		length--
		return old_tail?.value
	}

	fun printList() {
		var current = head
		println("Head: ${head?.value}, Tail: ${tail?.value}, Length: $length")

		while (current != null) {
			print("${current.value}")
			current = current.next
			if (current != null) {
				print(" -> ")
			}
		}

		println()
	}
}




//   LISTA DUPLAMENTE LIGADA:


class DoublyLinkedList<T> : LinkedList<T>() {
	override fun prepend(item: T) {
		val newNode = Node(item)
		length++

		if (head == null) {
			head = newNode
			tail = newNode
			return
		}

		newNode.next = head
		head!!.previous = newNode
		head = newNode
	}

	override fun append(item: T) {
		val newNode = Node(item)
		length++

		if (head == null) {
			head = newNode
			tail = newNode
			return
		}

		tail!!.next = newNode
		newNode.previous = tail
		tail = newNode

	}

	override fun insertAt(index: Int, item: T) {
		if (index < 0 || index > length) {
			throw IndexOutOfBoundsException()
		} else if (index == length) {
			this.append(item)
		} else if (index == 0) {
			this.prepend(item)
		} else {
			var current = head
			for (i in 0 until index) {
				current = current !!.next
			}

			current = current as Node<T>

			val newNode = Node(item)
			val previousNode = current.previous

			previousNode?.next = newNode
			newNode.previous = previousNode
			newNode.next = current
			current.previous = newNode
			length++
		}
	}

	override fun deleteTail(): T? {
		if (tail == null){
			return null
		}

		val old_tail = tail
		tail = tail?.previous

		if (tail == null) {
			head = null
		} else {
			tail!!.next = null
		}

		old_tail!!.previous = null
		length--

		return old_tail.value
	}
}


/*
OPERAÇÕES:
    - add no inicio, no fim, e em posição específica | FEITO
    - delete no inicio | FEITO, no fim | FEITO, e em posição específica
    - retornar tamanho | FEITO
    - buscar nó por valor
    - buscar um nó específico e alterar o valor dele
    - inverter | FEITO
 */

/* Não possui índice
   Para adicionar ou excluir elementos você tem que gerenciar os "next" e os "previous" em volta */
