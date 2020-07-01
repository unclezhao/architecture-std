package me.zy.std.ood.solid.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class WinForm extends AbstractComponent {

    private List<Component> subComponents = new ArrayList<>();

    public WinForm(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print WinForm(" + getName() + ")");
        for (Component sub : subComponents) {
            sub.display();
        }
    }

    public WinForm addSubComponent(Component component) {
        this.subComponents.add(component);
        return this;
    }
}
