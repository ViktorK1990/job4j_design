package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (container.length == size) {
            container = grow();
        }
            container[size] = value;
            size++;
            modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index,size);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T element = container[index];
       System.arraycopy(container, index +1, container, index, container.length - index -1);
       container[container.length -1] = null;
       modCount++;
       size--;
       return element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int point = 0;
            @Override
            public boolean hasNext() {
                if(expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }

    private T[] grow() {
        return container.length == 0 ? Arrays.copyOf(container, container.length + 2) :
                Arrays.copyOf(container, container.length * 2);
    }
}
