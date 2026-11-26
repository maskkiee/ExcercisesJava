package Excercises.TASK12;

import java.util.*;

public class NestedTwoKeyHashMap<K1, K2, V> implements TwoKeyMap<K1, K2, V> {
    private final Map<K1, Map<K2, V>> rows;
    private int size;

    public NestedTwoKeyHashMap() {
        this.rows = new HashMap<>();
        this.size = 0;
    }

    @Override
    public V put(K1 k1, K2 k2, V value) {
        checkKeys(k1, k2);
        Objects.requireNonNull(value, "Cannot be null");

        Map<K2, V> row = this.rows.get(k1);
        if (row == null) {
            row = new HashMap<>();
            this.rows.put(k1, row);
        }
        V oldValue = row.put(k2, value);
        if (oldValue == null) {
            size++;
        }
        return oldValue;
    }

    @Override
    public V get(K1 k1, K2 k2) {
        checkKeys(k1, k2);

        Map<K2, V> row = this.rows.get(k1);
        if (row == null) {
            return null;
        }
        return row.get(k2);
    }

    @Override
    public V remove(K1 k1, K2 k2) {
        checkKeys(k1, k2);

        Map<K2, V> row = this.rows.get(k1);
        if (row == null) {
            return null;
        }
        V oldValue = row.remove(k2);

        if (oldValue == null) {
            size--;
            if (rows.isEmpty()) {
                this.rows.remove(k1);
            }
        }
        return oldValue;
    }

    @Override
    public boolean containsKeys(K1 k1, K2 k2) {
        checkKeys(k1, k2);
        Map<K2, V> row = this.rows.get(k1);
        return row != null && row.containsKey(k2);
    }

    @Override
    public boolean containsValue(V value) {
        Objects.requireNonNull(value, "Cannot be null");
        for (Map<K2, V> row : this.rows.values()) {
            if (row.containsValue(value)) {
                return true;
            }
        }
        return false;
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
    public void clear() {
        rows.clear();
        size = 0;
    }

    @Override
    public Set<Entry<K1, K2, V>> entrySet() {
        Set<Entry<K1, K2, V>> result = new LinkedHashSet<>();
        for (Map.Entry<K1, Map<K2, V>> row : this.rows.entrySet()) {
            K1 key1 = row.getKey();
            for (K2 key2 : row.getValue().keySet()) {
                result.add(new MapEntry<>(this, row.getKey(), key2));
            }
        }
        return result;
    }

    @Override
    public Set<Pair<K1, K2>> keySet() {
        Set<Pair<K1, K2>> result = new LinkedHashSet<>();
        for (Map.Entry<K1, Map<K2, V>> row : this.rows.entrySet()) {
            for (K2 key2 : row.getValue().keySet()) {
                result.add(Pair.of(row.getKey(), key2));
            }
        }
        return result;
    }

    @Override
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        for (Map<K2, V> row : rows.values()) {
            result.addAll(row.values());
        }
        return result;
    }

    @Override
    public Iterator<Entry<K1, K2, V>> iterator() {
        return entrySet().iterator();
    }

    private void checkKeys(K1 k1, K2 k2) {
        Objects.requireNonNull(k1, "k1 can't be null");
        Objects.requireNonNull(k2, "k2 can't be null");
    }

    @Override
    public String toString() {
        return rows.toString();
    }
}
