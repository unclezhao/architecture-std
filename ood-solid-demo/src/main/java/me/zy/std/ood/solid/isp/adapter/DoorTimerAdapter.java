package me.zy.std.ood.solid.isp.adapter;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class DoorTimerAdapter implements TimerClient {

    private TimedDoor timedDoor;

    public DoorTimerAdapter(TimedDoor timedDoor) {
        this.timedDoor = timedDoor;
    }

    @Override
    public void timeout(int timeOutID) {
        this.timedDoor.doorTimeOut(timeOutID);
    }
}
