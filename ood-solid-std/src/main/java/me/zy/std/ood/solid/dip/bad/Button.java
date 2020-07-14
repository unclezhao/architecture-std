package me.zy.std.ood.solid.dip.bad;

import java.util.Random;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class Button {

    private Lamp lamp;
    private boolean isActivated;

    public Button(Lamp lamp) {
        this.lamp = lamp;
    }

    public void poll() {
        if (isActivated) {
            lamp.turnOff();
        } else {
            lamp.turnOn();
        }
    }

    public void activate() {
        this.isActivated = true;
    }

    public void deactivate() {
        this.isActivated = false;
    }

}
