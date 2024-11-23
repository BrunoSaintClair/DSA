package DataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LinkedListTest {

	@Test
	fun `test append adds item to end of list`() {
		val list = Linkedlist<Int>()
		list.append(10)
		list.append(20)

		assertEquals(2, list.getSize())
		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
		assertFalse(list.isEmpty())
	}

	@Test
	fun `test prepend adds item to start of list`() {
		val list = Linkedlist<Int>()
		list.prepend(10)
		list.prepend(20)

		assertEquals(2, list.getSize())
		assertEquals(20, list.get(0))
		assertEquals(10, list.get(1))
	}

	@Test
	fun `test insertAt adds item at specific index`() {
		val list = Linkedlist<Int>()
		list.append(10)
		list.append(30)
		list.insertAt(1, 20)

		assertEquals(3, list.getSize())
		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
		assertEquals(30, list.get(2))
	}

	@Test
	fun `test insertAt at index 0 behaves like prepend`() {
		val list = Linkedlist<Int>()
		list.append(10)
		list.insertAt(0, 5)

		assertEquals(2, list.getSize())
		assertEquals(5, list.get(0))
	}

	@Test
	fun `test insertAt throws exception for invalid index`() {
		val list = Linkedlist<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.insertAt(2, 20)
		}
	}

	@Test
	fun `test get retrieves correct item`() {
		val list = Linkedlist<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		assertEquals(10, list.get(0))
		assertEquals(20, list.get(1))
		assertEquals(30, list.get(2))
	}

	@Test
	fun `test get throws exception for invalid index`() {
		val list = Linkedlist<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.get(1)
		}
	}

	@Test
	fun `test isEmpty returns true for empty list`() {
		val list = Linkedlist<Int>()
		assertTrue(list.isEmpty())
	}

	@Test
	fun `test isEmpty returns false for non-empty list`() {
		val list = Linkedlist<Int>()
		list.append(10)
		assertFalse(list.isEmpty())
	}
}
