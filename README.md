# Lab 1, Library Catalog
Due date: September 14, 11:59pm

Please start by clicking on this link: https://classroom.github.com/a/fwUigZ94

For this project you will implement a "library catalog". You need to fill in code in four classes (in /src/catalog): 
- Book (represents a book in the library catalog that can be checked out and returned back to the library)
- LibraryCatalog (contains an ArrayList of books, and methods to operate on it)
- UserInterface  (allows a user to interact with the library catalog)

Documentation for project is available in the doc folder of the project (Start by opening index.html in your browser).

You are required to use the provided starter code (please note that class Driver has been already written for you). 
Do not modify method signatures, otherwise you will not be able to pass the tests.
You may not modify the provided tests. The input files books5.csv and books85.csv are in the "input" subfolder. This is real data (slightly modified for the assignment),
obtained from the following link:
https://www.kaggle.com/zygmunt/goodbooks-10k#books.csv and contain information about a set of popular books and their average ratings from goodreads. 

The file contains book_id, isbn, authors, original_publication_year,original_title, and a lot of other information for each book in csv format. 
Please note that you will need only the title, the author, the year and the average rating of each book from this file.

Your code will read a list of books from the given file and add them to the library catalog. 
The program would allow users to interact with the catalog by using keyboard input. 
Users should be able to check out books from the library, return books to the library and print the list of available books. 

### Submission
The code must be in your private github repo created by Github Classroom for this assignment. 
The code must compile, run as expected and pass provided Junit tests. Please note that class Userinterface needs to be tested manually since it relies on keyboard input.
Also, the provided tests are basic and passing them does not guarantee that your program is correct, you are responsible for additional testing.

Important: You are required to have at least 8 meaningful commits before the deadline to get any credit for this assignment. 
Please commit and push your changes frequently as you finish reasonable chunks of work.

Your code should follow style guidelines posted on Canvas!
