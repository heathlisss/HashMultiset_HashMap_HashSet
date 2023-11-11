package org.example;

import java.util.Iterator;

//позволяет добовлять одинаковые элементы в set и хранит колличество одинаковых элементов
public class NewHashMultiset<E> {
    private final NewHashMap<E, Integer> map;

    public NewHashMultiset() {
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

    public Object[][] toArray() {
        return map.toArray(new Object[map.size()][2]);
    }

    public <T> T[][] toArray(T[][] a) {
        return map.toArray(a);
    }

    public void add(E e) {
        if (contains(e)) map.put(e, map.get(e) + 1);
        else map.put(e, 1);

    }

    public void remove(E o) {
        if (contains(o) && (map.get(o) > 1)) map.put(o, map.get(o) - 1);
        else map.remove(o);
    }

    public void clear() {
        map.clear();
    }

}
