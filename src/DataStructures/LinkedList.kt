package DataStructures

// Linked lists não possuem índice
// Para adicionar ou excluir elementos você tem que gerenciar os "next" e os "previous" em volta

open class LinkedList<T> {
	var head: Node<T>? = null
	var tail: Node<T>? = null
	var size: Int = 0

	fun isEmpty(): Boolean = size == 0
	fun getListSize(): Int = size
	fun getFirst(): Node<T>? = head
	fun getLast(): Node<T>? = tail
	fun contains(value: T): Boolean { return find(value) != null }

	fun get(index: Int): Node<T>? {
		if (index < 0 || index >= size) throw IndexOutOfBoundsException()

		var current = head
		for (i in 0 until index) {
			current = current?.next
		}

		return current
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

		size++
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

		size++
	}

	open fun insertAt(index: Int, item: T) {
		if (index < 0 || index > size) {
			throw IndexOutOfBoundsException()
		} else if (index == size) {
			this.append(item)
		} else if (index == 0) {
			this.prepend(item)
		} else {
			var current = head
			for (i in 0 until index - 1) {
				current = current!!.next
			}

			val newNode = Node(item)
			newNode.next = current!!.next
			current.next = newNode

			if (newNode.next == null) {
				tail = newNode
			}

			size++
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

	fun deleteHead(): T? {
		if (head == null) return null

		val old_head_value = head!!.value
		head = head!!.next

		size--
		return old_head_value
	}

	open fun deleteTail(): T? {
		if (tail == null) return null

		if (head == tail) {
			val oldTailValue = tail?.value
			head = null
			tail = null
			size--
			return oldTailValue
		}

		var curr = head
		while (curr?.next != tail) {
			curr = curr!!.next
		}

		val old_tail = tail
		curr?.next = null
		tail = curr

		size--
		return old_tail?.value
	}

	open fun removeAt(index: Int): Node<T>? {
		if (tail == null || head == null) return null
		if (index < 0 || index > size) throw IndexOutOfBoundsException()

		var curr: Node<T>? = head

		for (i in 0 until index - 1){
			if (curr == null) return null
			curr = curr.next
		}

		val temp: Node<T>? = curr?.next?.next
		val droppedNode = curr?.next
		curr?.next?.next = null
		curr?.next = temp

		size--
		return droppedNode
	}

	fun updateAt(index: Int, newValue: T) {
		val node = get(index) ?: throw IndexOutOfBoundsException()
		node.value = newValue
	}

	 fun find(value: T): Node<T>? {
		var current = head
		while (current != null) {
			if (current.value == value) return current
			current = current.next
		}
		return null
	}

	fun printList() { // função extra pra auxiliar a visualização da lista/métodos.
		var current = head
		println("Head: ${head?.value}, Tail: ${tail?.value}, Size: $size")

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
		size++

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
		size++

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
		if (index < 0 || index > size) {
			throw IndexOutOfBoundsException()
		} else if (index == size) {
			append(item)
		} else if (index == 0) {
			prepend(item)
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
			size++
		}
	}

	override fun deleteTail(): T? {
		if (tail == null) return null

		val old_tail = tail
		tail = tail?.previous

		if (tail == null) {
			head = null
		} else {
			tail!!.next = null
		}

		old_tail!!.previous = null
		size--

		return old_tail.value
	}

	override fun removeAt(index: Int): Node<T>? {
		if (tail == null || head == null) return null
		if (index < 0 || index > size) throw IndexOutOfBoundsException()

		var curr: Node<T>? = head

		for (i in 0 until index - 1){
			if (curr == null) return null
			curr = curr.next
		}

		val temp: Node<T>? = curr?.next?.next
		val droppedNode = curr?.next
		curr?.next?.next?.previous = curr

		curr?.next?.next = null
		curr?.next?.previous = null
		curr?.next = temp

		size--
		return droppedNode
	}
}


/*

OPERAÇÕES:

- isEmpty: Verifica se a lista está vazia. Complexidade: O(1)
- getListSize: Retorna o tamanho da lista. Complexidade: O(1)
- getFirst: Retorna o primeiro elemento da lista (head). Complexidade: O(1)
- getLast: Retorna o último elemento da lista (tail). Complexidade: O(1)
- contains: Verifica se a lista contém um valor específico. Complexidade: O(n)
- get: Retorna o nó na posição especificada. Complexidade: O(n)
- prepend: Adiciona um elemento no início da lista. Complexidade: O(1)
- append: Adiciona um elemento no final da lista. Complexidade: O(1)
- insertAt: Insere um elemento em uma posição específica. Complexidade: O(n)
- revert: Inverte a ordem da lista. Complexidade: O(n)
- deleteHead: Remove o primeiro elemento da lista. Complexidade: O(1)
- deleteTail: Remove o último elemento da lista. Complexidade: O(n) (na lista simples) ou O(1) (na lista duplamente ligada)
- removeAt: Remove um elemento em uma posição específica. Complexidade: O(n)
- printList: Exibe os elementos da lista. Complexidade: O(n)
- updateAt: Atualiza o valor de um nó na posição especificada. Complexidade: O(n)
- find: Localiza um nó com base no valor. Complexidade: O(n)

*/
