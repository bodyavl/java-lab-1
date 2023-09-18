package org.lab;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int getNumberInputInRange(Scanner in, int range) {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int val = Integer.parseInt(in.nextLine());
                if (val >= 1 && val < range) { // <-- from "0" to "range".
                    return val;
                }
            } else {
                System.out.println("The value was not valid, please, try again: ");
                in.next();
            }
        }
        return -1;
    }
    public static void displayBook(Book book) {
        if (book == null) {
            System.out.println("No book was found with this data");
            return;
        }
        System.out.printf("Title: %s\n", book.title);
        System.out.printf("Author: %s\n", book.author);
        System.out.printf("ISBN: %s\n", book.ISBN);
        System.out.printf("Release Year: %s\n", book.releaseYear);
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true;
        while(isRunning) {
            System.out.print("Enter a number of action:\n1 - Add book\n2 - Search book by title\n3 - Remove book by ISBN\n4 - Show all books\n5 - Exit application\n");
            int action = getNumberInputInRange(scanner, 5);
            switch (action) {
                case 1 -> {
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.println("Enter release year: ");
                    int releaseYear = getNumberInputInRange(scanner, 2023);
                    library.AddBook(new Book(title, author, ISBN, releaseYear));
                }
                case 2 -> {
                    System.out.println("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    displayBook(library.GetBookByTitle(bookTitle));
                }
                case 3 -> {
                    System.out.println("Enter ISBN: ");
                    String bookISBN = scanner.nextLine();
                    Book removedBook = library.RemoveBook(bookISBN);
                    if (removedBook != null) System.out.println("Removed Book: ");
                    displayBook(removedBook);
                }
                case 4 -> {
                    ArrayList<Book> books = library.ShowBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books yet");
                        break;
                    }
                    for (Book book : books) {
                        displayBook(book);
                        System.out.println();
                    }
                }
                case 5 -> {
                    isRunning = false;
                    System.exit(0);
                }
            }
            System.out.println("Continue? yes/no");
            String answer = scanner.nextLine();
            if(answer.toLowerCase() == "yes") break;

        }

    }
}