package org.example;

public class MyHashMap<K, V> {

    private static final int INITIAL_SIZE = 1 << 4; // 16
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private Entry<K, V>[] table;

    public MyHashMap() {
        table = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        table = new Entry[tableSize];
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    public void put(K key, V value) {
        int index = (key.hashCode() & 0x7fffffff) % table.length;
        Entry<K, V> node = table[index];

        if (node == null) {
            table[index] = new Entry<>(key, value);
            return;
        }

        Entry<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            prev = node;
            node = node.next;
        }
        prev.next = new Entry<>(key, value);
    }

    public V get(K key) {
        int index = (key.hashCode() & 0x7fffffff) % table.length;
        Entry<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
}
