package org.example;

public class Main {

    public static void main(String[] args) {

        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shrayansh");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        System.out.println(map.get(8));   // you
        System.out.println(map.get(5));   // Shrayansh
        System.out.println(map.get(100)); // null
    }
}
