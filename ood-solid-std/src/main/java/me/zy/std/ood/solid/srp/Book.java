package me.zy.std.ood.solid.srp;

/**
 * @author zhaoyang on 2020-07-01.
 */
public class Book {

    public Book(String title, String author, Integer totalPage) {
        this.title = title;
        this.author = author;
        this.totalPage = totalPage;
    }

    private String title;
    private String author;
    private Integer totalPage;
    private Integer currPage = 0;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void prevPage() {
        Integer prevPage = --currPage;
        if (prevPage <= 0) {
            prevPage = 0;
        }
        turnToPage(prevPage);
    }

    public void nextPage() {
        Integer nextPage = ++currPage;
        if (nextPage >= totalPage) {
            nextPage = totalPage;
        }
        turnToPage(nextPage);
    }

    public void turnToPage(Integer toPage) {
        currPage = toPage;
    }

    public String getCurrentPage() {
        return "current page " + currPage + " content";
    }
}
