package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-07-01.
 */
public abstract class AbstractComponent implements Component {

    protected String name;

    public AbstractComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
