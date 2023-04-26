package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList <E> implements LinkedList<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> head;

    @Override
    public void add(E value) {
   Node<E> tempNode = head;
   Node<E> newNode = new Node<>(value, tempNode);
   head = newNode;
   size++;
   modCount++;
        }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> newElement = head;
        E element = head.item;
        for(int i = 0; i < index; i++) {
            newElement = newElement.next;
            element = newElement.item;
        }

        return element;
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
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
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

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list.get(1));
    }
}
