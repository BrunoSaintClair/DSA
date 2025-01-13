package DataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// testes gerados pelo gpt para conferir se os métodos foram implementados corretamente

class DoublyLinkedListTest {

	@Test
	fun `test prepend updates previous of old head`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.prepend(5)

		val newHead = list.getFirst()
		val oldHead = newHead?.next

		assertEquals(10, oldHead?.value)
		assertEquals(newHead, oldHead?.previous)
	}

	@Test
	fun `test append updates previous of new tail`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(20)

		val newTail = list.getLast()
		val oldTail = newTail?.previous

		assertEquals(10, oldTail?.value)
		assertEquals(newTail, oldTail?.next)
	}

	@Test
	fun `test deleteTail sets previous of new tail to null`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(20)

		list.deleteTail()
		val newTail = list.getLast()

		assertEquals(10, newTail?.value)
		assertNull(newTail?.next)
	}

	@Test
	fun `test insertAt updates previous and next pointers correctly`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(30)
		list.insertAt(1, 20)

		val first = list.get(0)
		val middle = list.get(1)
		val last = list.get(2)

		assertEquals(10, first?.value)
		assertEquals(20, middle?.value)
		assertEquals(30, last?.value)

		assertEquals(first, middle?.previous)
		assertEquals(last, middle?.next)
		assertEquals(middle, last?.previous)
	}

	@Test
	fun `test removeAt updates previous and next pointers correctly`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		list.removeAt(1)
		val first = list.get(0)
		val last = list.get(1)

		assertEquals(10, first?.value)
		assertEquals(30, last?.value)

		assertEquals(last, first?.next)
		assertEquals(first, last?.previous)
	}

	@Test
	fun `test deleteTail makes list empty when it is the last node`() {
		val list = DoublyLinkedList<Int>()
		list.append(10)
		list.deleteTail()

		assertTrue(list.isEmpty())
		assertNull(list.getFirst())
		assertNull(list.getLast())
	}
}
