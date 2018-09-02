package catalog;

import java.util.Scanner;

/** This class allows the user to interact with the system
 * using keyboard input.
 */
public class UserInterface {
    public final static String CHECKOUT  = "1";
    public final static String RETURN  = "2";
    public final static String PRINT_AVAILABLE  = "3";
    public final static String EXIT  = "4";

    /**
     * The method interacts with the user allowing them
     * to checkout a book, to return a book, to see a list
     * of available books, and to exit the program.
     * @param lc Library Catalog
     */
    public void mainLoop(LibraryCatalog lc) {
        // FILL IN CODE
        // Repeatedly prompt the user:
        // To check out a book, enter 1
        // To return a book, enter 2
        // To see a list of books currently available, enter 3
        // To exit, enter 4

        // If the user enters 1, ask for the title, and if the book is available,
        // check it out

        // If the user enters 2, ask for the title, and if the book is currently
        // checked out, return it.

        // If a user enters 3, display all the books that are currently
        // available (not checked out).

        // If a user enters 4, exit the program


    } // mainLoop
}
