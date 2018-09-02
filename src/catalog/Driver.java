package catalog;

/** The class that contains the main method,
 *  the entry point to the program.  */
public class Driver {
    /**
     * Creates a library catalog, adds books from the file, creates
     * a UserInterface and calls it's mainLoop method to allow the user
     * to interact with the catalog.
     * @param args command line arguments, not used in this program
     */
    public static void main(String[] args) {
        LibraryCatalog lc = new LibraryCatalog();
        lc.addBooksFromFile("input/books5.csv");
        UserInterface ui = new UserInterface();
        ui.mainLoop(lc);
    }

}
