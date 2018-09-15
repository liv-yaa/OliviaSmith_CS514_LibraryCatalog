package catalog;

import java.util.*;

/** This class allows the user to interact with the system
 * using keyboard input.
 */
public class UserInterface {
    public final static String CHECKOUT  = "1";
    public final static String RETURN  = "2";
    public final static String PRINT_AVAILABLE  = "3";
    public final static String EXIT  = "4";

    /**
     * The method interacts with the user allowing them to checkout a book, to return a book, to see a list
     * of available books, and to exit the program.
     * @param lc Library Catalog
     *
     *         // Repeatedly prompt the user:
     *         // To check out a book, enter 1
     *         // To return a book, enter 2
     *         // To , enter 3
     *         // To exit, enter 4
     */
    public void mainLoop(LibraryCatalog lc) {
        // FILL IN CODE

        Scanner sc = new Scanner(System.in);
        
        String inputInt; // Using constants -

        do {
            System.out.println("Welcome to the Library Catalog!");
            System.out.println();
            System.out.println("- To check out a book, enter 1.");
            System.out.println("- To return a book, enter 2.");
            System.out.println("- To see a list of books currently available, enter 3.");
            System.out.println("- To exit, enter 4.");
            System.out.println();

            inputInt = sc.next();

            // If the user enters 1, ask for the title, and if the book is available, check it out
            if (inputInt.matches(CHECKOUT)) {

                boolean valid = true; // Checks that the user input (1-4) is valid.

                do {
                    System.out.println("What is the title to check out? Or to go back to main menu, enter 0.");
                    String title = sc.next();

                    if (title.matches("0")) {
                        valid = false;
                        break; // Go back to main menu
                    }

                    if (!(lc.checkoutBook(title))) { // Try to check out. If can't, prompts user to try again.
                        System.out.println("Book cannot be checked out. Please try again: ");
                        continue;
                    }
                    else {
                        valid = false;
                        System.out.println(title + " has been checked out. All Books (Updated): ");
                        System.out.println(lc.getAvailableBooks());
                    }
                } while (valid);

            }

            // If the user enters 2, ask for the title, and if the book is currently checked out, return it.
            else if (inputInt.matches(RETURN)) {

                boolean valid = true;

                do {
                    System.out.println("What is the title to return? Or to go back to main menu, enter 0.");
                    String title = sc.next();

                    if (title.matches("0")) {
                        valid = false;
                        break; // Go back to main menu
                    }

                    if (!(lc.returnBook(title))) {
                        System.out.println("Book cannot be returned. Please try again: ");
                        continue;
                    }

                    else {
                        valid = false;
                        System.out.println(title + " has been returned. All Books (Updated): ");
                        System.out.println(lc.getAvailableBooks());
                    }
                }
                while (valid);
            }
            // If a user enters 3, display all the books that are currently available (not checked out).
            else if (inputInt.matches(PRINT_AVAILABLE)) {

                System.out.println("All available books: ");
                System.out.println(lc.getAvailableBooks());
            }
        }
        while (!(inputInt.matches(EXIT))) ;
        System.out.println("Goodbye!"); // If a user enters 4, exit the program

    }
}
