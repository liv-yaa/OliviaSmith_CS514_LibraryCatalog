package catalog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;

/** LibraryCatalog Class - represents a collection of books, where each book can be "checked out" and "returned".
 */
public class LibraryCatalog {

    /** ArrayList to store the books in the catalog. Remember to initialize this array in the constructor of the class. */
    private ArrayList<Book> books;

    /** Constructor for LibraryCatalog */
    public LibraryCatalog() {
        // FILL IN CODE:
        books = new ArrayList<>();
    }

    /** Adds a book to the ArrayList of books (catalog)
     * @param book book to be added to the catalog */
    public void addBook(Book book) {
        // FILL IN CODE
        books.add(book);
    }

    /** Searches for the book with the given title in the ArrayList "books" and returns the book. Returns null if there is no book with this title.
     * @param title title of the book
     * @return reference to the Book with the given title */
    public Book findBook(String title) {
        // FILL IN CODE
        for (Book b: books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Checks out the book with the given title from the library. First, searches for the book with the given title, and then
     * checks it out (by calling the corresponding method in class Book), if it is not currently checked out.
     * The method returns true if it was able to check out the book, otherwise false.
     * @param title title of the book
     * @return true if was able to checkout a book, false otherwise
     */
    public boolean checkoutBook(String title) {

        // FILL IN CODE
        for (Book b : books) {
            if (b.getTitle().equals(title) && !(b.isCheckedOut())) {
                b.checkoutBook();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the book with the given title to the library. If the book is in the ArrayList of books, has the matching title and is
     * currently checked out, the method is going to "return" it (by calling the returnBook() method of class Book).
     * @param title title of the book to return
     * @return true if was able to return the book, false otherwise
     */
    public boolean returnBook(String title) {
        // FILL IN CODE
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.isCheckedOut()) {
                b.returnBook();
                return true;
            }
        }
        return false;
    }

    /** Reads the file with the given filename line by line; extracts book title, author, year and average rating from each line;
     * creates a Book object, and adds it to the ArrayList of books.
     * @param filename name of the file that contains books info */

    public void addBooksFromFile(String filename) {

        // FILL IN CODE. You can use Scanner or BufferedReader to read from the file.
        // To split the line into individual words (title, author, year, averageRating), use line.split("/").
        // To convert a String into an integer for the variable "year", you can use Integer.parseInt(String s) function.
        //You are required to catch FileNotFoundException or IOException in this method

        File f = new File(filename);

        try {
            // Happens only if we successfully open the file

            BufferedReader br = new BufferedReader(new FileReader(f));
            br.readLine(); // Reads the first line

            String line = null;
            while ((line = br.readLine()) != null) {

                String[] array = line.split(",");

                String fauthor = array[7].replace("\"", "");
                int fyear = (int) (Double.parseDouble(array[8]));
                String ftitle = array[9].replace("\"", "");
                double fAR = Double.parseDouble(array[12]);

                // Create a Book object
                Book bobj = new Book(ftitle, fauthor, fyear, fAR);

                // Add new book object to the ArrayList of books.
                books.add(bobj);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Can't open file.");
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Returns a String containing books that are available for checkout
     * @return string with books that are not checked out
     */
    public String getAvailableBooks() {
        // FILL IN CODE
        String out = "";

        // Find all books that are not checked out
        for (Book b : books) {
            if (!(b.isCheckedOut())) {
                out += b.toString() + System.lineSeparator();
            }
        }
        return out;
    }

    /**
     * Returns a string that contains information about all books from the catalog; one book per line in the same format as in
     * toString method in class Book.
     * Important: instead of adding newline character using "\n", add System.lineSeparator() - it will return the system-dependent line separator
     * @return string representation of the library catalog
     */
    public String toString() {
        // FILL IN CODE

        StringBuilder sb = new StringBuilder("");

        for (Book b : books) {
            sb.append(b.toString());
            sb.append(System.lineSeparator());
        }

        String result = sb.toString();
        return result;
    }
}
