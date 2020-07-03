package me.zy.std.consistenthash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhaoyang on 2020-07-03.
 */
public class KetamaHashFunction implements HashFunction {

    private static MessageDigest md5Digest;

    static {
        try {
            md5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
    }

    @Override
    public long hash(String key) {
        byte[] bKey = md5(key);
        long rv = ((long) (bKey[3] & 0xFF)<< 24)
            | ((long) (bKey[2] & 0xFF)<< 16)
            | ((long) (bKey[1] & 0xFF)<< 8)
            | (bKey[0] & 0xFF);
        return rv & 0xffffffffL;
    }

    private byte[] md5(String value) {
        md5Digest.reset();
        byte[] bytes;
        bytes = value.getBytes(StandardCharsets.UTF_8);
        md5Digest.update(bytes);
        return md5Digest.digest();
    }
}
