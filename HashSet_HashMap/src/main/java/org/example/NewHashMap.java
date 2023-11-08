package org.example;

import java.util.*;
import java.util.HashSet;

public class NewHashMap<K, V> implements Map<K, V> {
    public static final int BASE_LENGTH_OF_HASH_TABLE = 16;
    private int size;
    private Node<K, V>[] table;
    private Set<K> keySet;
    private Collection<V> values;
    private Set<Entry<K, V>> entrySet;


    public NewHashMap() {
        table = new Node[BASE_LENGTH_OF_HASH_TABLE];
        keySet = new HashSet<>();
        values = new HashSet<>();
        entrySet = new HashSet<>();
        size = 0;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    private Node<K, V> getNode(Object key) {
        int h = Objects.hashCode(key);
        Node<K, V> node = table[arrayIndex(h)];
        if (node != null) {
            if (node.getKey().equals(key)) return node;
            else while (node.next != null) {
                node = node.next;
                if (node.getKey().equals(key)) return node;
            }
        }
        return null;
    }

    private int arrayIndex(int hash) {
        return hash % table.length;
    }

    @Override
    public boolean containsValue(Object value) {
        if (table != null && size > 0) {
            for (Node<K, V> e : table) {
                for (; e != null; e = e.next) {
                    if (value != null && value.equals(e.value))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = getNode(key);
        assert node != null;
        return node.getValue();
    }

    @Override
    public V put(K key, V value) {
        if (containsKey(key)) {
            Node<K, V> node = getNode(key);

            entrySet.remove(node);

            V v = node.getValue();
            node.setValue(value);

            values.remove(v);
            values.add(value);
            entrySet.add(node);

            return v;
        } else {
            values.add(value);
            keySet.add(key);

            int h = Objects.hashCode(key);
            Node<K, V> node = new Node<>(h, key, value, null);

            entrySet.add(node);

            Node<K, V> nodePrevious = table[arrayIndex(h)];
            if (nodePrevious == null) table[arrayIndex(h)] = node;
            else while (nodePrevious.next != null) {
                nodePrevious = nodePrevious.next;
                if (nodePrevious.next == null)
                    nodePrevious.next = node;
            }
            size++;
            rewrite();
        }
        return null;
    }

    private void rewrite() {
        if (size > table.length) {
            Node<K, V>[] tableOld = table;
            Node<K, V>[] table = new Node[tableOld.length * 2];
            for (Node<K, V> e : tableOld) {
                for (; e != null; e = e.next) {
                    put(e.getKey(), e.getValue());
                }
            }
            System.out.println(table.length);
        }
    }

    @Override
    public V remove(Object key) {
        if (containsKey(key)) {
            size--;
            Node<K, V> node = getNode(key);
            V v = node.getValue();

            entrySet.remove(node);
            values.remove(v);
            keySet.remove(key);

            int index = arrayIndex(node.hashCode());
            Node<K, V> nodeСurrent = table[index];
            if (table[index].key == key) table[index] = table[index].next;
            else while (nodeСurrent.key != key) {
                if (nodeСurrent.next.key == key) {
                    nodeСurrent.next = nodeСurrent.next.next;
                    return v;
                }
                nodeСurrent = nodeСurrent.next;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (!m.isEmpty()) {
            for (Map.Entry entry : m.entrySet()) {
                put((K) entry.getKey(), (V) entry.getValue());
            }
        }
    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            size = 0;
            Arrays.fill(table, null);
        }
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }
}
