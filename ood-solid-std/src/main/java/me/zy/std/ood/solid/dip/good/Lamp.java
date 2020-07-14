package me.zy.std.ood.solid.dip.good;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class Lamp implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("The lamp now is turn on.");
    }

    @Override
    public void turnOff() {
        System.out.println("The lamp now is turn off.");
    }

}
