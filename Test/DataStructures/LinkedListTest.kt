package DataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// testes gerados pelo gpt para conferir se os métodos foram implementados corretamente

class LinkedListTest {

	@Test
	fun `test revert reverses the list`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		list.revert()

		assertEquals(30, list.get(0)?.value)
		assertEquals(20, list.get(1)?.value)
		assertEquals(10, list.get(2)?.value)
	}

	@Test
	fun `test deleteHead removes first item`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		val deleted = list.deleteHead()

		assertEquals(10, deleted)
		assertEquals(20, list.get(0)?.value)
		assertEquals(2, list.getListSize())
	}

	@Test
	fun `test deleteHead on empty list returns null`() {
		val list = LinkedList<Int>()

		val deleted = list.deleteHead()

		assertNull(deleted)
		assertEquals(0, list.getListSize())
	}

	@Test
	fun `test deleteTail removes last item`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		val deleted = list.deleteTail()

		assertEquals(30, deleted)
		assertEquals(20, list.get(1)?.value)
		assertEquals(2, list.getListSize())
	}

	@Test
	fun `test deleteTail on single-element list`() {
		val list = LinkedList<Int>()
		list.append(10)

		val deleted = list.deleteTail()

		assertEquals(10, deleted)
		assertTrue(list.isEmpty())
	}

	@Test
	fun `test removeAt removes item at index`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		val removed = list.removeAt(1)

		assertEquals(20, removed?.value)
		assertEquals(10, list.get(0)?.value)
		assertEquals(30, list.get(1)?.value)
		assertEquals(2, list.getListSize())
	}

	@Test
	fun `test removeAt throws exception for invalid index`() {
		val list = LinkedList<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.removeAt(2)
		}
	}

	@Test
	fun `test updateAt changes value at index`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		list.updateAt(1, 25)

		assertEquals(10, list.get(0)?.value)
		assertEquals(25, list.get(1)?.value)
		assertEquals(30, list.get(2)?.value)
	}

	@Test
	fun `test updateAt throws exception for invalid index`() {
		val list = LinkedList<Int>()
		list.append(10)

		assertThrows<IndexOutOfBoundsException> {
			list.updateAt(3, 40)
		}
	}

	@Test
	fun `test find returns correct node`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		val foundNode = list.find(20)
		assertNotNull(foundNode)
		assertEquals(20, foundNode?.value)
	}

	@Test
	fun `test find returns null for non-existent value`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)

		val foundNode = list.find(50)
		assertNull(foundNode)
	}

	@Test
	fun `test printList does not throw exception`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(20)
		list.append(30)

		assertDoesNotThrow {
			list.printList()
		}
	}

	@Test
	fun `test insertAt maintains correct head and tail references`() {
		val list = LinkedList<Int>()
		list.append(10)
		list.append(30)
		list.insertAt(1, 20)

		assertEquals(10, list.getFirst()?.value)
		assertEquals(30, list.getLast()?.value)
	}

	@Test
	fun `test empty list has null head and tail`() {
		val list = LinkedList<Int>()

		assertNull(list.getFirst())
		assertNull(list.getLast())
	}
}
