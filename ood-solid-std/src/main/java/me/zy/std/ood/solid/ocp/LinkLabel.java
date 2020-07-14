package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class LinkLabel extends AbstractComponent {

    public LinkLabel(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print LinkLabel(" + getName() + ")");
    }
}
