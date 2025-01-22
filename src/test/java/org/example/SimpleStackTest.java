package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    private Stack createStack() {
        return new SimpleStack();
    }

    @Test
    @DisplayName("Test the state of a newly created stack")
    public void testCreateEmptyStack() {
        // Given a new stack
        Stack stack = createStack();

        // Then it should be empty and have size 0
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals(0, stack.getSize(), "A new stack has no elements");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {
        // Given a stack and an item
        Stack stack = createStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then the stack should not be empty, and the size should be 1
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(), "The stack must contain 1 item");
        assertSame(item, stack.peek(), "The pushed item must be on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When the new item is pushed
        stack.push(item2);

        // Then the stack should contain 2 items, and the top should be the new item
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(2, stack.getSize(), "The stack must contain 2 items");
        assertSame(item2, stack.peek(), "The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack() {
        // Given an empty stack
        Stack stack = createStack();

        // When trying to pop, it should throw an EmptyStackException
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to peek an empty stack")
    public void testPeekOnEmptyStack() {
        // Given an empty stack
        Stack stack = createStack();

        // When trying to peek, it should throw an EmptyStackException
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test peeking the top item of a stack")
    public void testPeek() throws EmptyStackException {
        // Given a stack and an item
        Stack stack = createStack();
        Item item = new SimpleItem();

        // When the item is pushed onto the stack
        stack.push(item);

        // Then peek should return the pushed item without removing it
        assertSame(item, stack.peek(), "The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test popping an item from the stack")
    public void testPop() throws EmptyStackException {
        // Given a stack and two items
        Stack stack = createStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        // When the items are pushed onto the stack
        stack.push(item);
        stack.push(item2);

        // Then pop should return the top item and remove it from the stack
        Item itemPop = stack.pop();
        assertEquals(1, stack.getSize(), "The stack should contain 1 item after popping");
        assertSame(item2, itemPop, "The popped item should be the most recently pushed item");
    }
}
