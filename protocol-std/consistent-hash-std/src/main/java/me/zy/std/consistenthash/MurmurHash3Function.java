package me.zy.std.consistenthash;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author zhaoyang on 2020-07-03.
 */
public class MurmurHash3Function implements HashFunction {

    @Override
    public long hash(String key) {
        return Hashing.murmur3_128().hashString(key, StandardCharsets.UTF_8).asLong();
    }
}
