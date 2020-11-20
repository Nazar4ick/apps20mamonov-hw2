package ua.edu.ucu.collections;

import lombok.Getter;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    @Getter
    private ImmutableLinkedList items;
    public Stack() {
        items = new ImmutableLinkedList();
    }

    public Object peek() {
        return items.getLast();
    }

    public Object pop() {
        Object item = items.getLast();
        items = items.removeLast();
        return item;
    }

    public void push(Object e) {
        items = items.addLast(e);
    }
}
