package me.zy.std.ood.solid.dip.good;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class Button {

    private boolean isActivated;
    private Switchable switchable;

    public Button(Switchable switchable) {
        this.switchable = switchable;
    }

    public void poll() {
        if (this.isActivated) {
            switchable.turnOff();
        } else {
            switchable.turnOn();
        }
    }

    public void activate() {
        this.isActivated = true;
    }

    public void deactivate() {
        this.isActivated = false;
    }
}
