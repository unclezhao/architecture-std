package me.zy.std.consistenthash;

/**
 * @author zhaoyang on 2020-07-03.
 */
public interface HashFunction {

    /**
     * Calculate input key's hash value.
     *
     * @param key key for calculated
     * @return hash value
     */
    long hash(String key);

}
