package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleLinkedList <E> implements LinkedList<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> head;

    @Override
    public void add(E value) {
    if(head == null) {
        Node<E> newNode = new Node<>(value,null);
        head = newNode;
    }

        }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> newElement = head;
            @Override
            public boolean hasNext() {
                if(expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return newElement != null;
            }

            @Override
            public E next() {
                E element = newElement.item;
                newElement = newElement.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
