package org.furb.dataStructure;

import org.furb.dataStructure.exception.StackIsEmptyException;

public class Stack<T> {
    LinkedList<T> list;

    public Stack() {
        this.list = new LinkedList<>();
    }

    public void push(T item) {
        list.insert(item);
    }

    public void clear() {
        list = new LinkedList<>();
    }

    public T pop() {
        if(isEmpty()) throw new StackIsEmptyException();
        T item = peek();
        list.remove(item);
        return item;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if(isEmpty()) throw new StackIsEmptyException();
        return list.getFirst().getInfo();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
