package ru.job4j.collection;

import java.util.Iterator;

public interface SimpleList <T> extends Iterable<T> {
    void add(T value);
    T set(int index, T newValue);
    T remove(int index);
    T get(int index);
    int size();
}
