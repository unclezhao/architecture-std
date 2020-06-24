package me.zy.std.dubbo.serialization.protostuff.delegate;

import io.protostuff.Input;
import io.protostuff.Output;
import io.protostuff.Pipe;
import io.protostuff.WireFormat;
import io.protostuff.runtime.Delegate;

import java.io.IOException;
import java.sql.Time;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class TimeDelegate implements Delegate<Time> {
    @Override
    public WireFormat.FieldType getFieldType() {
        return WireFormat.FieldType.FIXED64;
    }

    @Override
    public Time readFrom(Input input) throws IOException {
        return new Time(input.readFixed64());
    }

    @Override
    public void writeTo(Output output, int num, Time time, boolean repeated) throws IOException {
        output.writeFixed64(num, time.getTime(), repeated);
    }

    @Override
    public void transfer(Pipe pipe, Input input, Output output, int num, boolean repeated) throws IOException {
        output.writeFixed64(num, input.readFixed64(), repeated);
    }

    @Override
    public Class<?> typeClass() {
        return Time.class;
    }
}
