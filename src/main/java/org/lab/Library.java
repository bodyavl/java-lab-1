package org.lab;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void AddBook(Book book) {
        books.add(book);
    }
    public void RemoveBook(String isbn) {
        for(Book book : books) {
            if(book.ISBM.equals(isbn)) {
                books.remove(book);
                return;
            }
        }
    }
    public ArrayList<Book> ShowBooks() {
        return books;
    }
    public Book GetBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) return book;
        }
        return null;
    }
}
