package org.lab.testing;

import org.junit.jupiter.api.Test;
import org.lab.Book;

public class BookTests {
    private Book book;

    @Test
    public void createBook () {
        final String title = "title";
        final String author = "author";
        final long ISBN = 0;
        final int releaseYear = 0;
        book = new Book(title, author, ISBN, releaseYear);
        if(!book.title.equals(title))
            throw new AssertionError("book.title should equal 'title'");
        if(!book.author.equals(author))
            throw new AssertionError("book.author should equal 'author'");
        if(book.ISBN != ISBN)
            throw new AssertionError("book.ISBN should equal 0");
        if(book.releaseYear != releaseYear)
            throw new AssertionError("book.releaseYear should equal 0");
    }
}
