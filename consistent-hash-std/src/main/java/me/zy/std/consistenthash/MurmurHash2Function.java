package me.zy.std.consistenthash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Document from Jedis MurmurHash.java:
 *
 * This is a very fast, non-cryptographic hash suitable for general hash-based lookup. See
 * http://murmurhash.googlepages.com/ for more details. <br>
 * <p>
 * The C version of MurmurHash 2.0 found at that site was ported to Java by Andrzej Bialecki (ab at
 * getopt org).
 * </p>
 *
 * @author zhaoyang on 2020-07-03.
 */
public class MurmurHash2Function implements HashFunction {


    /**
     * Jedis's implement for MurmurHash2.
     *
     * @param key key for calculated
     * @return hash value
     */
    @Override
    public long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
//        return h & 0xffffffffL;
    }

}
