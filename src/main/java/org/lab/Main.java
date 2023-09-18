package org.lab;

import javax.lang.model.element.Name;
import java.util.Scanner;

public class Main {

    public static int getNumberInputInRange(Scanner in, int range) {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int val = in.nextInt();
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
            System.out.println("No book was found with this title");
            return;
        }
        System.out.printf("Title: %s", book.title);
        System.out.printf("Author: %s", book.author);
        System.out.printf("ISBN: %s", book.ISBN);
        System.out.printf("Release Year: %s", book.releaseYear);
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true;
        while(isRunning) {
            System.out.print("Enter a number of action:\n1 - Add book\n2 - Search book by title\n3 - Remove book by ISBN\n4 - Show all books\n5 - Exit application");
            int action = getNumberInputInRange(scanner, 5);
            switch (action) {
                case 1:
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.println("Enter release year: ");
                    int releaseYear = getNumberInputInRange(scanner, 2023);
                    library.AddBook(new Book(title, author, ISBN, releaseYear));
                    break;
                case 2:
                    System.out.println("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    displayBook(library.GetBookByTitle(bookTitle));
                    break;
                case 3:

            }
        }

    }
}