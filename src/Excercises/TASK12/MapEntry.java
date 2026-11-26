package Excercises.TASK12;

import java.util.Objects;

public class MapEntry<K1, K2, V> implements TwoKeyMap.Entry<K1, K2, V> {
    private final TwoKeyMap<K1, K2, V> map;
    private final K1 k1;
    private final K2 k2;

    MapEntry(TwoKeyMap<K1, K2, V> map, K1 k1, K2 k2) {
        this.map = map;
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public K1 getKey1() {
        return k1;
    }

    @Override
    public K2 getKey2() {
        return k2;
    }

    @Override
    public V getValue() {
        return map.get(k1, k2);
    }

    @Override
    public V setValue(V value) {
        return map.put(k1, k2, value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TwoKeyMap.Entry<?, ?, ?> other)) return false;
        return Objects.equals(k1, other.getKey1()) && Objects.equals(k2, other.getKey2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(k1, k2);
    }

    @Override
    public String toString() {
        return "(" + k1 + ", " + k2 + ")=" + getValue();
    }
}