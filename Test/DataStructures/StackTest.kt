package DataStructures

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StackTest {

    @Test
    fun testPushAndPeek() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.peek())  // O elemento do topo deve ser 3 após empilhar 1, 2, 3
    }

    @Test
    fun testPop() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.pop())  // Remove o elemento do topo (3)
        assertEquals(2, stack.pop())  // O próximo elemento deve ser 2
    }

    @Test
    fun testIsEmpty() {
        val stack = Stack<Int>()
        assertTrue(stack.isEmpty())  // A pilha deve estar inicialmente vazia
        stack.push(1)
        assertFalse(stack.isEmpty())  // A pilha não deve estar vazia após uma inserção
    }

    @Test
    fun testSize() {
        val stack = Stack<Int>()
        assertEquals(0, stack.size())  // Tamanho inicial deve ser 0
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.size())  // Deve ter 2 elementos após duas inserções
        stack.pop()
        assertEquals(1, stack.size())  // Deve ter 1 elemento após uma remoção
    }

    @Test
    fun testPopOnEmptyStack() {
        val stack = Stack<Int>()
        assertNull(stack.pop())  // `pop` deve retornar null para uma pilha vazia
    }

    @Test
    fun testPeekOnEmptyStack() {
        val stack = Stack<Int>()
        assertNull(stack.peek())  // `peek` deve retornar null se a pilha estiver vazia
    }
}
