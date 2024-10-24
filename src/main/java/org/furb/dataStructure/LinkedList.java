package org.furb.dataStructure;

public class LinkedList<T> {

    private Node<T> first;

    public LinkedList() {
        first = null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>();
        newNode.setInfo(value);
        newNode.setNext(first);
        first = newNode;
    }

    boolean isEmpty() {
        return first == null;
    }

    public Node<T> search(T value) {
        Node<T> p = first;

        while (p != null) {
            if (p.getInfo().equals(value)) return p;
            p = p.getNext();
        }
        return null;
    }

    public void remove(T value) {
        Node<T> p = first;
        Node<T> beforeNode = null;

        while (p != null && !(p.getInfo().equals(value))) {
            beforeNode = p;
            p = p.getNext();
        }
        if (p != null) {
            if (p == first) {
                first = first.getNext();
                return;
            }

            beforeNode.setNext(p.getNext());
        }
    }

    public int getSize() {
        Node<T> p = first;
        int i = 0;
        while (p != null) {
            p = p.getNext();
            i++;
        }
        return i;
    }

    public Node<T> getNode(int idx) {
        Node<T> p = first;
        int i = 0;

        while (p != null && idx >= i) {
            if (i == idx) {
                return p;
            }
            p = p.getNext();
            i++;
        }

        if (idx < 0 || idx > i) throw new IndexOutOfBoundsException("Posição informada não existe.");
        return null;
    }

    @Override
    public String toString() {
        Node<T> p = first;
        String s = "";
        while (p != null) {
            if (p.getNext() == null) return s.concat(p.getInfo().toString());
            s = s.concat(p.getInfo() + ",");
            p = p.getNext();
        }
        return s;
    }
}
