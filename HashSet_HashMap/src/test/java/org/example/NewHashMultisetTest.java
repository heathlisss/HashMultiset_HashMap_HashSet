package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewHashMultisetTest {

    @Test
    void size() {
        var multSet = new NewHashMultiset<>();
        Assertions.assertEquals(0, multSet.size());
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertEquals(3, multSet.size());
        multSet.remove(1);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertEquals(2, multSet.size());
    }

    @Test
    void numberOfDublicates() {
        var multSet = new NewHashMultiset<>();
        multSet.add(2);
        multSet.add(3);
        Assertions.assertEquals(1, multSet.numberOfDublicates(3));
        multSet.add(2);
        multSet.add(2);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertEquals(2, multSet.numberOfDublicates(3));
        Assertions.assertEquals(4, multSet.numberOfDublicates(2));
    }

    @Test
    void isEmpty() {
        var multSet = new NewHashMultiset<Integer>();
        Assertions.assertTrue(multSet.isEmpty());
        multSet.add(1);
        multSet.add(1);
        Assertions.assertFalse(multSet.isEmpty());
        multSet.remove(1);
        Assertions.assertFalse(multSet.isEmpty());
        multSet.remove(1);
        Assertions.assertTrue(multSet.isEmpty());
    }

    @Test
    void contains() {
        var multSet = new NewHashMultiset<Integer>();
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertTrue(multSet.contains(1));
        Assertions.assertTrue(multSet.contains(2));
        multSet.remove(1);
        Assertions.assertFalse(multSet.contains(1));
        Assertions.assertTrue(multSet.contains(3));
    }

    @Test
    void toArray() {
        var multSet = new NewHashMultiset<Integer>();
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertArrayEquals(new Integer[][]{{1, 1}, {2, 1}, {3, 1}}, multSet.toArray());
        multSet.add(2);
        multSet.add(3);
        multSet.add(3);
        Assertions.assertArrayEquals(new Integer[][]{{1, 1}, {2, 2}, {3, 3}}, multSet.toArray());
    }

    @Test
    void add() {
        var multSet = new NewHashMultiset<Integer>();
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        Assertions.assertTrue(multSet.contains(1));
        Assertions.assertTrue(multSet.contains(2));
        multSet.remove(1);
        Assertions.assertFalse(multSet.contains(1));
        Assertions.assertTrue(multSet.contains(3));
    }

    @Test
    void remove() {
        var multSet = new NewHashMultiset<Integer>();
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        multSet.remove(1);
        Assertions.assertFalse(multSet.contains(1));
        multSet.add(2);
        multSet.remove(2);
        Assertions.assertTrue(multSet.contains(3));
        multSet.remove(2);
        multSet.remove(3);
        Assertions.assertFalse(multSet.contains(2));
        Assertions.assertFalse(multSet.contains(3));
    }

    @Test
    void clear() {
        var multSet = new NewHashMultiset<Integer>();
        multSet.add(1);
        multSet.add(2);
        multSet.add(3);
        multSet.add(2);
        multSet.add(3);
        multSet.add(3);
        multSet.clear();
        Assertions.assertFalse(multSet.contains(1));
        Assertions.assertFalse(multSet.contains(2));
        Assertions.assertFalse(multSet.contains(3));
    }
}