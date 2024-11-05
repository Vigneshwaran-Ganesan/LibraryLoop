package libraryApp;

public class Book {

    private int isbn;
    private String title;
    private String author;
    private String genre;
    private int quantity;
    private int checkedOut;

    // Constructor for book object
    public Book(int isbn, String title, String author, String genre, int quantity, int checkedOut) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.checkedOut = Math.max(0, Math.min(checkedOut, quantity)); // Ensure checkedOut is within bounds
    }

    public void setCheckedOut(int checkedOut) {
        // Ensure that the checked out count does not exceed the quantity
        if (checkedOut >= 0 && checkedOut <= quantity) {
            this.checkedOut = checkedOut;
        } else {
            throw new IllegalArgumentException("Checked out cannot be negative or exceed total quantity.");
        }
    }

    public int getCheckedIn() {
        return quantity - checkedOut; // Calculate checked in as the available quantity
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
    }

    // Getter Methods
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCheckedOut() {
        return checkedOut;
    }

    // Override toString for easy display of book details
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Genre: %s, ISBN: %d, Quantity: %d, Checked Out: %d, Available: %d",
                title, author, genre, isbn, quantity, checkedOut, getCheckedIn());
    }
}
