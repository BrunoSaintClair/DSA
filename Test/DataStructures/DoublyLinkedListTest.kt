package DataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DoublyLinkedListTest {

	@Test
	fun `test append adds item to end of doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(20)

		assertEquals(2, list.getSize())
		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
	}

	@Test
	fun `test prepend adds item to start of doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.prepend(10)
		list.prepend(20)

		assertEquals(2, list.getSize())
		assertEquals(20, list.get(0))
		assertEquals(10, list.get(1))
	}

	@Test
	fun `test insertAt adds item at specific index in doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(30)
		list.insertAt(1, 20)

		assertEquals(3, list.getSize())
		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
		assertEquals(30, list.get(2))
	}

	@Test
	fun `test insertAt at index 0 behaves like prepend in doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.insertAt(0, 5)

		assertEquals(2, list.getSize())
		assertEquals(5, list.get(0))
		assertEquals(10, list.get(1))
	}

	@Test
	fun `test insertAt throws exception for invalid index in doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.insertAt(2, 20)
		}
	}

	@Test
	fun `test get retrieves correct item in doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
		assertEquals(30, list.get(2))
	}

	@Test
	fun `test get throws exception for invalid index in doubly linked list`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.get(1)
		}
	}
}
