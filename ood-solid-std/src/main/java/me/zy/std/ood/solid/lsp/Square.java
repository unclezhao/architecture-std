package me.zy.std.ood.solid.lsp;

/**
 * @author zhaoyang on 2020-07-07.
 */
public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
