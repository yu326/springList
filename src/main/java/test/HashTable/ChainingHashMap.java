package test.HashTable;

/**
 * Created by koreyoshi on 2017/10/9.
 */
public class ChainingHashMap<K, V>  {
    private int num; //当前散列表中的键值对总数
    private int capacity; //桶数
    private SeqSearchST<K, V>[] st; //链表对象数组

    public ChainingHashMap(int initialCapacity) {
        capacity = initialCapacity;
        st = (SeqSearchST<K, V>[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            st[i] = new SeqSearchST();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }


    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V value) {
        st[hash(key)].put(key, value);
    }

}
