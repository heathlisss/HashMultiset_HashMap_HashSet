package org.example;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        NewHashMap<Integer,Integer> hash = new NewHashMap<>();
        hash.put(8, 108);
        hash.put(8,199);
        hash.put(9, 99);
        hash.remove(8);
        System.out.println(hash.containsValue(99));
        Set<Integer> set = new HashSet<>();
    }
}