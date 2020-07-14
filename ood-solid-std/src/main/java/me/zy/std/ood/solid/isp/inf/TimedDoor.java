package me.zy.std.ood.solid.isp.inf;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class TimedDoor implements Door, TimerClient {
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

    @Override
    public void timeout(int timeOutID) {

    }
}
