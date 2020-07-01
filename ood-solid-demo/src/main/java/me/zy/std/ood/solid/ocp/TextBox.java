package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class TextBox extends AbstractComponent {

    public TextBox(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print TextBox(" + getName() + ")");
    }
}
