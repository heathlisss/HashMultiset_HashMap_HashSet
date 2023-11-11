package org.example;

import java.util.*;

public class NewHashSet<E> {
    private final NewHashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public NewHashSet() {
        map = new NewHashMap<>();
    }

    public int size() {
        return map.size();
    }


    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public Object[] toArray() {
        Object[] array = new Object[map.size()];
        if (!map.isEmpty()) {
            int i = 0;
            for (E key : map.keySet()) {
                array[i] = key;
                i++;
            }
        }
        return array;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length >= map.size()) {
            if (!map.isEmpty()) {
                int i = 0;
                for (E key : map.keySet()) {
                    a[i] = (T) key;
                    i++;
                }
            }
            return a;
        }
        return null;
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public void remove(Object o) {
        map.remove(o);
    }

    public void clear() {
        map.clear();
    }

}
