package org.example;

import java.util.ArrayList;

public class SimpleStack implements Stack {
    private ArrayList<Item> elements;

    public SimpleStack() {
        elements = new ArrayList<Item>();
    }
    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return elements.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        this.elements.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        return this.elements.get(elements.size() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if(this.isEmpty()) {throw new EmptyStackException();}
        Item i = this.peek();
        this.elements.remove(elements.size() - 1);
        return i;
    }
}
