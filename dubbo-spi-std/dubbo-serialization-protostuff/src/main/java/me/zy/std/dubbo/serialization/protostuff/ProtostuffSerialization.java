package me.zy.std.dubbo.serialization.protostuff;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class ProtostuffSerialization implements Serialization {

    private static final byte PROTOSTUFF_SERIALIZATION_ID = 12;

    public ProtostuffSerialization() {
        System.out.println("protostuff serialization initialized");
    }

    @Override
    public byte getContentTypeId() {
        return PROTOSTUFF_SERIALIZATION_ID;
    }

    @Override
    public String getContentType() {
        return "x-application/protostuff";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        return new ProtostuffObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return new ProtostuffObjectInput(input);
    }

}
