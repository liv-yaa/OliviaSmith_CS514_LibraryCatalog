package catalog;

/** Class Book represents a book in the library catalog */
public class Book {

    // FILL IN CODE: declare private instance variables: title, author, year, averageRating, isCheckedOut:
    private String title;
    private String author;
    private int year;
    private double averageRating;
    private boolean isCheckedOut;

    /**
     * Constructor of class Book
     * @param title title of the book
     * @param author author of the book
     * @param year year when the book was first published
     * @param avgRating average rating on goodreads
     */
    public Book(String title, String author, int year, double avgRating) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.averageRating = avgRating;
        isCheckedOut = false;
    }

    /**
     * Return true if the book is currently checked out and false otherwise.
     * @return value of boolean variable isCheckedOut
     */
    public boolean isCheckedOut() {
        // FILL IN CODE - this is sufficient to return true / false (since the value was initialized in the constructor
        return isCheckedOut;
    }

    /**
     * Return the title of the book
     * @return title
     */
    public String getTitle() {
        // FILL IN CODE
        return title;
    }

    /** Return average rating of the book from goodreads
     * @return average rating */
    public double getAverageRating() {
        // FILL IN CODE
        return averageRating;
    }

    /**
     * Check out the book if it is available by updating isCheckedOut variable.
     * If the book is not available (checked out), return false
     * @return true if was able to checkout the book, and false otherwise
     */
    public boolean checkoutBook() {
        // FILL IN CODE

        if (isCheckedOut == false) {
            isCheckedOut = true;
            return true;
        }
        return false;
    }

    /** Return the book if it is currently checked out, return true. If the book is not checked out (can not return), return false
     * @return true if was able to return a book, false otherwise */

    public boolean returnBook() {
        // FILL IN CODE
        if (isCheckedOut == true) {
            isCheckedOut = false;
            return true;
        }
        return false;
    }

    /** Return a string with the information about the book in the following format: (title, author, year, averageRating)
     * @return string representation of the book */

    public String toString() {
        // FILL IN CODE
        return "(" + title + ", " + author + ", " + year + ", " + averageRating + ")";
    }
}
