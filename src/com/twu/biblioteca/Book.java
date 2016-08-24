package com.twu.biblioteca;


/**
 * Created by Suraj on 24-08-2016.
 */

class Book {
    private int book_id;
    private String title;
    private String author;
    private String year_published;

    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear_published() {
        return year_published;
    }

    public Book(int book_id, String title, String author, String year_published) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.year_published = year_published;
    }
}
