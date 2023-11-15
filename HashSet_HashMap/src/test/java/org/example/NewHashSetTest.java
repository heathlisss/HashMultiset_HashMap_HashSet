package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewHashSetTest {

    @Test
    void size() {
        var set = new NewHashSet<Integer>();
        Assertions.assertEquals(0, set.size());
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertEquals(3, set.size());
        set.remove(1);
        Assertions.assertEquals(2, set.size());
    }

    @Test
    void isEmpty() {
        var set = new NewHashSet<Integer>();
        Assertions.assertTrue(set.isEmpty());
        set.add(1);
        Assertions.assertFalse(set.isEmpty());
        set.remove(1);
        Assertions.assertTrue(set.isEmpty());
    }

    @Test
    void contains() {
        var set = new NewHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        set.remove(1);
        Assertions.assertFalse(set.contains(1));
        Assertions.assertTrue(set.contains(3));
    }

    @Test
    void toArray() {
        var set = new NewHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3}, set.toArray());
    }

    @Test
    void add() {
        var set = new NewHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }

    @Test
    void remove() {
        var set = new NewHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        set.remove(1);
        set.remove(2);
        set.remove(3);
        Assertions.assertFalse(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertFalse(set.contains(3));
    }

    @Test
    void clear() {
        var set = new NewHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.clear();
        Assertions.assertFalse(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertFalse(set.contains(3));
    }
}