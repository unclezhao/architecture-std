package me.zy.std.ood.solid.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyang on 2020-06-22.
 */
public class Frame extends AbstractComponent {

    private List<Component> subComponents = new ArrayList<>();

    public Frame(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("print Frame(" + getName() + ")");
        for (Component sub : subComponents) {
            sub.display();
        }
    }

    public Frame addSubComponent(Component component) {
        this.subComponents.add(component);
        return this;
    }
}
