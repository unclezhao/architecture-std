package me.zy.std.ood.solid.ocp;

/**
 * @author zhaoyang on 2020-06-22.
 */
public interface Component {

    /**
     * Gui component's name
     * @return name
     */
    String getName();

    /**
     * Display detail info
     */
    void display();

}
