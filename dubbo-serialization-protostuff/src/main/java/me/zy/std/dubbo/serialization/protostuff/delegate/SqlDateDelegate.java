package me.zy.std.dubbo.serialization.protostuff.delegate;

import io.protostuff.Input;
import io.protostuff.Output;
import io.protostuff.Pipe;
import io.protostuff.WireFormat;
import io.protostuff.runtime.Delegate;

import java.io.IOException;
import java.sql.Date;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class SqlDateDelegate implements Delegate<Date> {

    @Override
    public WireFormat.FieldType getFieldType() {
        return WireFormat.FieldType.FIXED64;
    }

    @Override
    public java.sql.Date readFrom(Input input) throws IOException {
        return new java.sql.Date(input.readFixed64());
    }

    @Override
    public void writeTo(Output output, int number, java.sql.Date value, boolean repeated) throws IOException {
        output.writeFixed64(number, value.getTime(), repeated);
    }

    @Override
    public void transfer(Pipe pipe, Input input, Output output, int number, boolean repeated) throws IOException {
        output.writeFixed64(number, input.readFixed64(), repeated);
    }

    @Override
    public Class<?> typeClass() {
        return java.sql.Date.class;
    }
}
