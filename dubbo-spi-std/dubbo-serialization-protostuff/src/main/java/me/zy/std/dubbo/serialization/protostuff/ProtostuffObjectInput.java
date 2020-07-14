package me.zy.std.dubbo.serialization.protostuff;

import com.alibaba.dubbo.common.serialize.ObjectInput;
import io.protostuff.GraphIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import me.zy.std.dubbo.serialization.protostuff.utils.WrapperUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class ProtostuffObjectInput implements ObjectInput {

    private DataInputStream dis;

    public ProtostuffObjectInput(InputStream inputStream) {
        dis = new DataInputStream(inputStream);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        int classNameLength = dis.readInt();
        int bytesLength = dis.readInt();

        if (classNameLength < 0 || bytesLength < 0) {
            throw new IOException();
        }

        byte[] classNameBytes = new byte[classNameLength];
        dis.readFully(classNameBytes, 0, classNameLength);

        byte[] bytes = new byte[bytesLength];
        dis.readFully(bytes, 0, bytesLength);

        String className = new String(classNameBytes);
        Class clazz = Class.forName(className);

        Object result;
        if (WrapperUtils.needWrapper(clazz)) {
            Schema<Wrapper> schema = RuntimeSchema.getSchema(Wrapper.class);
            Wrapper wrapper = schema.newMessage();
            GraphIOUtil.mergeFrom(bytes, wrapper, schema);
            result = wrapper.getData();
        } else {
            Schema schema = RuntimeSchema.getSchema(clazz);
            result = schema.newMessage();
            GraphIOUtil.mergeFrom(bytes, result, schema);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T readObject(Class<T> clazz) throws IOException, ClassNotFoundException {
        return (T) readObject();
    }

    @Override
    public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
        return readObject(cls);
    }

    @Override
    public boolean readBool() throws IOException {
        return dis.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return dis.readByte();
    }

    @Override
    public short readShort() throws IOException {
        return dis.readShort();
    }

    @Override
    public int readInt() throws IOException {
        return dis.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return dis.readLong();
    }

    @Override
    public float readFloat() throws IOException {
        return dis.readFloat();
    }

    @Override
    public double readDouble() throws IOException {
        return dis.readDouble();
    }

    @Override
    public String readUTF() throws IOException {
        int length = dis.readInt();
        byte[] bytes = new byte[length];
        dis.read(bytes, 0, length);
        return new String(bytes);
    }

    @Override
    public byte[] readBytes() throws IOException {
        int length = dis.readInt();
        byte[] bytes = new byte[length];
        dis.read(bytes, 0, length);
        return bytes;
    }
}
