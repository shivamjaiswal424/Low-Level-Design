package org.example;

import java.util.Objects;

public class MyHashMap<K,V> {
    public static final int INITIAL_CAPACITY = 1<<4; //16
    public static final int MAXIMUM_CAPACITY = 1<<30;
    public static final float LOAD_FACTOR = 0.75f;


    Entry<K,V>[] hashTable;
    int size;
    int threshold;

    MyHashMap(){
        hashTable = new Entry[INITIAL_CAPACITY];
        threshold = (int)(INITIAL_CAPACITY*LOAD_FACTOR);
    }
    MyHashMap(int capacity){
        int size=tableSize(capacity);
        hashTable = new Entry[size];
        threshold = (int)(size*LOAD_FACTOR);
    }
    static int hash(Object key){
        if(key==null) return 0;
        int hash = key.hashCode();
        return hash^(hash>>>16);


    }
    int tableSize(int capacity){
        int n=capacity-1;
        n|=n>>1;
        n|=n>>2;
        n|=n>>4;
        n|=n>>8;
        n|=n>>16;
        return (n<0) ? 1 : (n>=MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n+1;
    }

    static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

    }
    void put(K key,V value){
        int hashCode = hash(key);
        int index=hashCode & (hashTable.length-1);

        Entry<K,V> head = hashTable[index];
        Entry<K,V> current = head;
        while(current!=null){
            if(Objects.equals(current.key,key)){
                current.value = value;
                return;
            }
            current=current.next;
        }
        Entry<K,V> newEntry = new Entry<>(key,value);
        newEntry.next = head;
        hashTable[index] = newEntry;
        size++;
        if(size>threshold){
            resize();
        }
    }

    public V get(K key){
        int hashCode = hash(key);
        int index=hashCode & (hashTable.length-1);
        Entry<K,V> current = hashTable[index];
        while(current!=null){
            if(Objects.equals(current.key,key)){
                return current.value;
            }
            current=current.next;
        }
        return null;
    }
    public void resize(){
        Entry<K,V>[] oldTable = hashTable;
        int newCapacity = hashTable.length*2;
        hashTable = new Entry[newCapacity];
        threshold = (int)(newCapacity*LOAD_FACTOR);
        for (Entry<K,V> head: oldTable){
            while(head!=null){
                Entry<K,V> next = head.next;
                int index=hash(head.key) & newCapacity-1;
                head.next = hashTable[index];
                hashTable[index] = head;
                head = next;

            }
        }


    }
    public static void main(String[] args) {
        MyHashMap<Integer,String> map = new MyHashMap<>();

        map.put(1,"Hello");
        map.put(2,"My");
        map.put(3,"Name");
        map.put(4,"Is");
        map.put(5,"Shivam");

        System.out.println(map.get(5));
    }
}
