package libraryApp;

public class LibraryApp {

    BookRepository repo = new BookRepository();

    public void findByTitle(String title) {
        if (repo.searchByTitle(title)) {
            System.out.println("Books found with title containing: " + title);
        } else {
            System.out.println("No books found with title containing: " + title);
        }
    }

    public void findByISBN(int isbn) {
        if (repo.searchByISBN(isbn)) {
            System.out.println("Book found with ISBN: " + isbn);
        } else {
            System.out.println("No book found with ISBN: " + isbn);
        }
    }

    public boolean findByGenre(String genre) {
        boolean found = repo.searchByGenre(genre);
        if (found) {
            System.out.println("Books found in genre: " + genre);
        } else {
            System.out.println("No books found in genre: " + genre);
        }
        return found;
    }

    public int findISBN(int isbn) {
        return repo.searchISBN(isbn);
    }

    public boolean withdrawBook(int isbn) {
        return repo.getBook(isbn);
    }

    public boolean depositBook(int isbn) {
        return repo.submitBook(isbn);
    }

    public void getStatus(int isbn) {
        repo.bookStatus(isbn);
    }
}
