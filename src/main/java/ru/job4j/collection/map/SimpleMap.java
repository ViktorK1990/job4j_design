package ru.job4j.collection.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        var result = false;
        if (count == capacity) {
            expand();
        }
        if (key != null) {
            var index = indexFor(hash(key.hashCode()));
            table[index] = new MapEntry<>(key, value);
            result = true;
        } else {
            table[0] = new MapEntry<>(null, value);
            result = true;
        }
        count++;
        modCount++;

        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        for (MapEntry<K, V> e : oldTable) {
            put(e.key, e.value);
        }

    }

    @Override
    public V get(K key) {
        V element = null;
        var index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            if (table[index].key.hashCode() == key.hashCode() && table[index].key.equals(key)) {
                element = table[index].value;
            }
        }
        return element;
    }

    @Override
    public boolean remove(K key) {
        boolean remove = false;
        var index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            if (table[index].key.hashCode() == key.hashCode() && table[index].key.equals(key)) {
                table[index] = null;
                remove = true;
                count--;
                modCount++;
            }
        }
        return remove;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int point = 0;
            int expectedCount = modCount;

            @Override
            public boolean hasNext() {
                var result = false;
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (point < table.length) {
                    for (int i = point; i < table.length; i++) {
                        if (table[i] != null) {
                            point = i;
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }


    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public static void main(String[] args) {

    }
}