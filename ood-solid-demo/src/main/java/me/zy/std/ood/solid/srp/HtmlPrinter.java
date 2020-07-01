package me.zy.std.ood.solid.srp;

/**
 * @author zhaoyang on 2020-07-01.
 */
public class HtmlPrinter implements Printable {
    @Override
    public void print(String content) {
        System.out.println(String.format("<html> %s </html>", content));
    }
}
