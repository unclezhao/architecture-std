package me.zy.std.ood.solid.isp.adapter;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class TimedDoor implements Door {
    @Override
    public void lock() {

    }

    @Override
    public void unlock() {

    }

    @Override
    public boolean isDoorOpen() {
        return false;
    }

    public void doorTimeOut(int timeOutID) {

    }
}
