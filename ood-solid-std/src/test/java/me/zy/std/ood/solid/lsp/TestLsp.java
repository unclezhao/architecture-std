package me.zy.std.ood.solid.lsp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author zhaoyang on 2020-07-08.
 */
public class TestLsp {

    @Test
    public void testRectangleArea() {
        Rectangle rec = new Rectangle();
        rec.setWidth(5);
        rec.setHeight(4);
        assertEquals("", 20, rec.area());
    }

    @Test(expected = AssertionError.class)
    public void testSquareArea() {
        Rectangle rec = new Square();
        rec.setWidth(5);
        rec.setHeight(4);
        assertEquals("Against LSP", 20, rec.area());
    }

}
