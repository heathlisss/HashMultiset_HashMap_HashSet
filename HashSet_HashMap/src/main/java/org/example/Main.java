package org.example;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> hash = new NewHashMap<>();
        hash.put(8, 108);
        hash.put(8,199);
        hash.put(9, 99);
        hash.remove(8);
        Set<Integer> set =  hash.keySet();
    }
}