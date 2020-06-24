package me.zy.std.dubbo.serialization.protostuff;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class Wrapper<T> {

    private T data;

    Wrapper(T data) {
        this.data = data;
    }

    Object getData() {
        return data;
    }
}
