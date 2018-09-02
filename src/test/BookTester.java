package test;

import catalog.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** A class for testing methods of class Book */
public class BookTester {
    private Book book;

    /** Will be invoked before every test */
    @Before
    public void setup() {
        book = new Book("The Da Vinci Code", "Dan Brown", 2003,3.79);

    }

    /** Test getTitle method */
    @Test
    public void testTitleGetter() {
        assertTrue(book.getTitle().equals("The Da Vinci Code"));
    }

    /** Tests getAverageRating method */
    @Test
    public void testAvgRatingGetter() {
        double avgRating = book.getAverageRating();
        assertTrue(Math.abs(avgRating - 3.79) < 0.001);

    }

    /** Tests checkoutBook method. After invoking it, the book
     *  should be checked out.
     */
    @Test
    public void testCheckoutAvailable() {
        assertTrue(book.checkoutBook());
        assertTrue(book.isCheckedOut());
    }

    /** Tests checkoutBook method. After calling it once on a particular
     * title, we should not be able to check out the same title again
     * (until we return the book).
     */
    @Test
    public void testCheckoutNonAvailable() {
        book.checkoutBook();
        assertFalse(book.checkoutBook()); // should not be able to check out again
    }


    /** Tests testReturn method. After the book is checked out, we
     *  should be able to return it using this method. And after returning
     *  the book, isCheckedOut should be false.
     */
    @Test
    public void testReturn() {
        book.checkoutBook();
        assertTrue(book.returnBook());
        assertTrue(!book.isCheckedOut());
    }

    /** Tests toString method of class Book. Makes sure the method returns
     * book info in the correct format
     */
    @Test
    public void testToString() {
        String studentRes = book.toString();
        String expectedRes = "(The Da Vinci Code, Dan Brown, 2003, 3.79)";
        assertEquals("toString method does not return what is expected", studentRes, expectedRes);
    }

}
