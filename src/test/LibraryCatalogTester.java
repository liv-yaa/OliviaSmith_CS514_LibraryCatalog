package test;

import catalog.Book;
import catalog.LibraryCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** A class for testing methods in class LibraryCatalog */
public class LibraryCatalogTester {
    private LibraryCatalog lc;

    /** Will be invoked before every test */
    @Before
    public void setup() {
        lc = new LibraryCatalog();
        //lc.addBooksFromFile("input/books85.csv");
    }


    /** Tests toString method of class LibraryCatalog */
    @Test
    public void testToString() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        String studentResult = lc.toString();
        System.out.println(studentResult);
        String expectedResult = "(Charlotte's web, DE. B. White, 1954, 3.7)" + System.lineSeparator() +
                "(Harry Potter, J. Rowling, 1999, 3.8)" + System.lineSeparator() +
                "(Mrs Frisby and the rats of NIMH, Robert O'Brien, 1970, 3.9)" + System.lineSeparator();
        assertTrue("toString method returns the string that does not match the expected result", studentResult.equals(expectedResult));
    }

    /** Tests findBook method of class LibraryCatalog.
     *  Adds a book and then checks if it can find it. */
    @Test
    public void testFindBook() {
        lc.addBook(new Book("The Da Vinci Code", "Dan Brown", 2003,3.79));
        Book foundBook = lc.findBook("The Da Vinci Code");
        assertTrue("findBook was not able to find added book", foundBook != null);
        assertTrue("findBook finds a wrong book", foundBook.getTitle().equals("The Da Vinci Code"));

    }

    /** Tests findBook method - checks what happens when we search for a book
     *  that is not present in the catalog.
     */
    @Test
    public void testFindUnavailableBook() {
        lc.addBook(new Book("The Da Vinci Code", "Dan Brown", 2003,3.79));
        Book foundBook = lc.findBook("Harry Potter");
        assertTrue("findBook found a book that was never added", foundBook == null);
    }

    /** Tests checkoutBook method of class LibraryCatalog.
     *  When the book is present and available, we should be able to check out. */
    @Test
    public void testCheckoutAvailableBook() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        boolean flag = lc.checkoutBook("Harry Potter");
        assertTrue("checkoutBook was not able to checkout available book", flag);
    }

    /** Tests checkoutBook method, for the case when
     * the book is not in the catalog. */
    @Test
    public void testCheckoutBookNotInCatalog() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        boolean flag = lc.checkoutBook("Jurassic Park");
        assertTrue("checkoutBook checked out the book that is not in the catalog", !flag);
    }

    /** Tests checkoutBook method of class LibraryCatalog, checks
     *  the case when the book is currently checked out, so we
     *  should not be able to check out again. */
    @Test
    public void testCheckoutNonAvailableBook() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        lc.checkoutBook("Harry Potter");
        boolean flag = lc.checkoutBook("Harry Potter"); // try to checkout again
        assertFalse("checkoutBook checked out non-available book", flag);
    }

    /** Tests returnBook of class LibraryCatalog, makes sure that when
     * the book is not checked out, we can not return it. */
    @Test
    public void testReturnNonCheckedOutBook() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        boolean flag = lc.returnBook("Harry Potter");
        assertFalse("returnBook was able to return a book that was never checked out", flag);
    }

    /**
     * Tests returnBook method. If the book is currently checked out,
     * we should be able to return it.
     */
    @Test
    public void testReturnCheckedOutBook() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        boolean flag = lc.checkoutBook("Harry Potter");
        flag = lc.returnBook("Harry Potter");
        assertTrue("returnBook was not able to return a book", flag);
    }

    /**
     * Tests addBooksFromFile method. Relies on toString method to
     * return a correct string, after loading books from books5.csv
     */
    @Test
    public void testAddBooksFromFile() {
        lc.addBooksFromFile("input/books5.csv");
        String studentResult = lc.toString();
        String expectedResult = "(The Hunger Games, Suzanne Collins, 2008, 4.34)" + System.lineSeparator() +

        "(Harry Potter and the Philosopher's Stone, J.K. Rowling, 1997, 4.44)" + System.lineSeparator() +
        "(Twilight, Stephenie Meyer, 2005, 3.57)" + System.lineSeparator() +
        "(To Kill a Mockingbird, Harper Lee, 1960, 4.25)" + System.lineSeparator() +
        "(The Great Gatsby, F. Scott Fitzgerald, 1925, 3.89)" + System.lineSeparator();

        assertTrue("After loading books from books5.csv, the result returned by toString method of LibraryCatalog does not match the expected result", studentResult.equals(expectedResult));
    }

    /** Tests getAvailableBooks method. Makes sure it shows only the books
     *  that are not checked out.
     */
    @Test
    public void testGetAvailableBooks() {
        lc.addBook(new Book("Charlotte's web", "DE. B. White", 1954,3.7));
        lc.addBook(new Book("Harry Potter", "J. Rowling", 1999,3.8));
        lc.addBook(new Book("Mrs Frisby and the rats of NIMH", "Robert O'Brien", 1970,3.9));
        lc.checkoutBook("Harry Potter");
        String studentResult = lc.getAvailableBooks();
        String expectedResult = "(Charlotte's web, DE. B. White, 1954, 3.7)" + System.lineSeparator()
                + "(Mrs Frisby and the rats of NIMH, Robert O'Brien, 1970, 3.9)" + System.lineSeparator();
        assertTrue("getAvailableBooks method returns the string that does not match the expected result", studentResult.equals(expectedResult));
    }

}

