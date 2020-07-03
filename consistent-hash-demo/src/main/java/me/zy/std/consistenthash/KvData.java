package me.zy.std.consistenthash;

/**
 * @author zhaoyang on 2020-07-03.
 */
public interface KvData<K,V> {

    /**
     * KV data's key, it can be use to do mapping operation with hash ring.
     *
     * @return kv data's key
     */
    K key();

    /**
     * KV data's value.
     * because we don't concern about this value in the question,
     * so implement by default with return null value.
     *
     * @return kv data's value
     */
    default V value() {
        return null;
    }

}
