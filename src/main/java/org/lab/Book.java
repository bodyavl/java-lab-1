package org.lab;

public class Book {
    public String title;
    public String author;
    public String ISBM;
    public int releaseYear;

    public Book(String title, String author, String ISBM, int releaseYear) {
        this.title = title;
        this.author = author;
        this.ISBM = ISBM;
        this.releaseYear = releaseYear;
    }
}
