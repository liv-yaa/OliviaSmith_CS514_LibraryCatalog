package catalog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** LibraryCatalog Class - represents a collection of books,
 *  where each book can be "checked out" and "returned".
 */
public class LibraryCatalog {

    /* ArrayList to store the books in the catalog. Remember to
    initialize this array in the constructor of the class. */
    private ArrayList<Book> books;

    /**
     * Constructor for LibraryCatalog
     */
    public LibraryCatalog() {
        // FILL IN CODE: initialize the ArrayList books here

    }

    /** Adds a book to the ArrayList of books.
     *
     * @param book book to be added to the catalog
     */
    public void addBook(Book book) {
        // FILL IN CODE

    }


    /**
     * Searches for the book with the given title in the ArrayList
     * "books" and returns the book. Returns null if there is no book
     *  with this title.
     * @param title title of the book
     * @return reference to the Book with the given title
     */
    public Book findBook(String title) {
        // FILL IN CODE

        return null; // remember to change it
    }

    /**
     * Checks out the book with the given title from the library.
     *  First, searches for the book with the given title, and then
     * checks it out (by calling the corresponding method in class Book)
     * if it is not currently checked out. The method returns true if it
     * was able to check out the book, otherwise false.
     * @param title title of the book
     * @return true if was able to checkout a book, false otherwise
     */
    public boolean checkoutBook(String title) {

        // FILL IN CODE
        return false; // remember to change it
    }

    /**
     * Returns the book with the given title to the library. If the
     * book is in the ArrayList of books, has the matching title and is
     * currently checked out, the method is going to "return" it (by
     * calling the returnBook() method of class Book.
     * @param title title of the book to return
     * @return true if was able to return the book, false otherwise
     */
    public boolean returnBook(String title) {
        // FILL IN CODE

        return false; // remember to change it
    }

    /**
     * Reads the file with the given filename line by line;
     * extracts book title, author, year and average rating from each line;
     * creates a Book object, and adds it to the ArrayList of books.
     *
     * @param filename name of the file that contains books info
     */
    public void addBooksFromFile(String filename) {

        // FILL IN CODE
        // You can use Scanner or BufferedReader to read from the file.
        // To split the line into individual words (title, author, year, averageRating),
        // use line.split("/").

        // To convert a String into an integer for the
        // variable "year", you can use Integer.parseInt(String s) function.
        // You are required to catch FileNotFoundException or IOException
        // in this method

    }


    /**
     * Returns a String containing books that are available for checkout
     * @return string with books that are not checked out
     */
    public String getAvailableBooks() {
        // FILL IN CODE

        return ""; // remember to change it
    }

    /**
     * Returns a string that contains information about all books
     * from the catalog; one book per line in the same format as in
     * toString method in class Book.
     * Important: instead of adding newline character using
        "\n", add System.lineSeparator() - it will return the system-dependent line separator

     * @return string representation of the library catalog
     */
    public String toString() {
        // FILL IN CODE
        return ""; // remember to change it
    }

}
