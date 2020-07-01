package me.zy.std.ood.solid.srp;

/**
 * @author zhaoyang on 2020-07-01.
 */
public class EpubFormatDownloader implements Downloadable {
    @Override
    public void download(Book book) {
        System.out.println(String.format("Book %s download with format EPUB", book.getTitle()));
    }
}
