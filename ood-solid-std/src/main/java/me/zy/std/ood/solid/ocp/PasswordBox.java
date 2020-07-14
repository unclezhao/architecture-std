package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class PasswordBox extends AbstractComponent {

    public PasswordBox(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print PasswordBox(" + getName() + ")");
    }
}
