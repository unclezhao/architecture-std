package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class CheckBox extends AbstractComponent {

    public CheckBox(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print CheckBox(" + getName() + ")");
    }
}
