package DataStructures

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class QueueTest {

    @Test
    fun testEnqueueAndPeek() {
        val queue = Queue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(1, queue.peek())  // O primeiro elemento deve ser 1
    }

    @Test
    fun testDequeue() {
        val queue = Queue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(1, queue.dequeue())  // Remove o primeiro elemento (1)
        assertEquals(2, queue.dequeue())  // O próximo deve ser 2
    }

    @Test
    fun testIsEmpty() {
        val queue = Queue<Int>()
        assertTrue(queue.isEmpty())  // A fila deve estar inicialmente vazia
        queue.enqueue(1)
        assertFalse(queue.isEmpty())  // A fila não deve estar vazia após a inserção
    }

    @Test
    fun testSize() {
        val queue = Queue<Int>()
        assertEquals(0, queue.size())  // Tamanho inicial deve ser 0
        queue.enqueue(1)
        queue.enqueue(2)
        assertEquals(2, queue.size())  // Deve ter 2 elementos após duas inserções
        queue.dequeue()
        assertEquals(1, queue.size())  // Deve ter 1 elemento após uma remoção
    }

    @Test
    fun testDequeueOnEmptyQueue() {
        val queue = Queue<Int>()
        assertNull(queue.dequeue())  // `dequeue` deve retornar null para uma fila vazia
    }

    @Test
    fun testPeekOnEmptyQueue() {
        val queue = Queue<Int>()
        assertNull(queue.peek())  // `peek` deve retornar null se a fila estiver vazia
    }
}