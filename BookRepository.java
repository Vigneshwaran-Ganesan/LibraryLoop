package libraryApp;

import java.util.ArrayList;

public class BookRepository {

    private ArrayList<Book> books = new ArrayList<>();
    private int booksFound = 0;

    // Constructor to initialize books
    public BookRepository() {
        books.add(new Book(253910, "Pride and Prejudice", "Jane Austen", "Love", 10, 7));
        books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        books.add(new Book(715332, "Shrimad Bhagavad Gita", "Krishna Dvaipayana", "Motivational", 20, 18));
        books.add(new Book(935141, "Java: The Complete Reference", "Herbert Schildt", "Educational", 12, 9));
        books.add(new Book(459901, "It", "Stephen King", "Horror", 7, 5));
        books.add(new Book(855141, "Disneyland", "Mickey & Minnie", "Love", 10, 3));
    }

    // Searching books by Title Keyword
    public boolean searchByTitle(String title) {
        booksFound = 0;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                bookDetails(book);
                booksFound++;
            }
        }
        System.out.printf("\n%d Book%s Found.\n", booksFound, booksFound > 1 ? "s" : "");
        return booksFound > 0;
    }

    // Searching books by ISBN Number
    public boolean searchByISBN(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                bookDetails(book);
                System.out.printf("\n1 Book Found.\n");
                return true; // Book found
            }
        }
        System.out.printf("\n0 Books Found.\n");
        return false; // Book not found
    }

    // Searching books by Genre
    public boolean searchByGenre(String genre) {
        booksFound = 0;
        for (Book book : books) {
            if (book.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                bookDetails(book);
                booksFound++;
            }
        }
        System.out.printf("\n%d Book%s Found.\n", booksFound, booksFound > 1 ? "s" : "");
        return booksFound > 0;
    }

    // Display Book Details
    public void bookDetails(Book book) {
        System.out.println("\n+> Book details: \n");
        System.out.println("\tTitle: " + book.getTitle()
                + "\n\tAuthor: " + book.getAuthor()
                + "\n\tGenre: " + book.getGenre()
                + "\n\tISBN: " + book.getIsbn()
                + "\n\tQuantity: " + book.getQuantity()
                + "\n\tChecked Out: " + book.getCheckedOut()
                + "\n\tAvailable: " + (book.getQuantity() - book.getCheckedOut()));
    }

    // Searching for ISBN number for checkIn and checkOut
    public int searchISBN(int isbn) {
        for (Book book : books)
            if (book.getIsbn() == isbn)
                return 1; // Book found
        return 0; // Book not found
    }

    // Withdrawing book (checking out)
    public boolean getBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if ((book.getQuantity() - book.getCheckedOut()) > 0) {
                    book.setCheckedOut(book.getCheckedOut() + 1);
                    return true; // Book checked out successfully
                }
            }
        }
        return false; // No available copies to check out
    }

    // Submitting book (checking in)
    public boolean submitBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (book.getCheckedOut() > 0) {
                    book.setCheckedOut(book.getCheckedOut() - 1);
                    return true; // Book checked in successfully
                }
            }
        }
        return false; // No copies checked out to return
    }

    // Showing status of book
    public void bookStatus(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                bookDetails(book);
                break; // Break after displaying the first matching book
            }
        }
    }
}
