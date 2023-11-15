package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NewHashMapTest {

    @Test
    void size() {
        var map = new NewHashMap<Integer, Integer>();
        Assertions.assertEquals(0, map.size());
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Assertions.assertEquals(3, map.size());
        map.put(1, 2);
        Assertions.assertEquals(3, map.size());
    }

    @Test
    void isEmpty() {
        var map = new NewHashMap<Integer, Integer>();
        Assertions.assertTrue(map.isEmpty());
        map.put(1, 1);
        Assertions.assertFalse(map.isEmpty());
        map.remove(1);
        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    void containsKey() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        Assertions.assertFalse(map.containsKey(2));
        Assertions.assertTrue(map.containsKey(1));
        map.put(2, 1);
        map.put(3, 1);
        map.remove(1);
        Assertions.assertFalse(map.containsKey(1));
        Assertions.assertTrue(map.containsKey(2));
    }

    @Test
    void containsValue() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        Assertions.assertFalse(map.containsValue(2));
        Assertions.assertTrue(map.containsValue(1));
        map.put(2, 2);
        map.put(3, 3);
        map.remove(1);
        Assertions.assertFalse(map.containsValue(1));
        Assertions.assertTrue(map.containsValue(3));
    }

    @Test
    void get() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 111);
        Assertions.assertEquals(111, map.get(1));
        map.put(1, 1);
        Assertions.assertEquals(1, map.get(1));
    }

    @Test
    void put() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        Assertions.assertTrue(map.containsKey(1));
        Assertions.assertTrue(map.containsValue(1));
        map.put(2, 1);
        Assertions.assertTrue(map.containsKey(2));
        Assertions.assertFalse(map.containsValue(2));
    }

    @Test
    void remove() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 1);
        map.remove(2);
        Assertions.assertFalse(map.containsKey(2));
        map.remove(1);
        Assertions.assertFalse(map.containsKey(1));
    }

    @Test
    void putAll() {
        var map1 = new NewHashMap<Integer, Integer>();
        var map2 = new NewHashMap<Integer, Integer>();
        map1.put(1, 1);
        map2.put(2, 2);
        map2.put(1, 2);
        map2.put(3, 2);
        map1.putAll(map2);
        Assertions.assertTrue(map1.containsKey(1));
        Assertions.assertTrue(map1.containsKey(2));
        Assertions.assertTrue(map1.containsKey(3));
        Assertions.assertTrue(map1.containsValue(2));
        Assertions.assertFalse(map1.containsValue(1));
    }

    @Test
    void clear() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 1);
        map.clear();
        Assertions.assertEquals(0, map.size());
        Assertions.assertFalse(map.containsKey(1));
        Assertions.assertFalse(map.containsKey(2));
        Assertions.assertFalse(map.containsKey(3));
        Assertions.assertFalse(map.containsKey(4));
    }

    @Test
    void keySet() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        var set1 = map.keySet();
        var set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(2);
        Assertions.assertArrayEquals(set2.toArray(), set1.toArray());
    }

    @Test
    void values() {
        var map = new NewHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        var ar = map.values();
        Assertions.assertArrayEquals(new Integer[] {1, 2, 2}, ar.toArray());
    }
}