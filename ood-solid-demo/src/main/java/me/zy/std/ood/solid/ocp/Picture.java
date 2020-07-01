package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class Picture extends AbstractComponent {

    public Picture(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print Picture(" + getName() + ")");
    }
}
