import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Queue<String>> waitList; // Stores queues of users waiting for books

    public Library() {
        books = new HashMap<>();
        waitList = new HashMap<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        if (!books.containsKey(book.getBookId())) {
            books.put(book.getBookId(), book);
            waitList.put(book.getBookId(), new LinkedList<>());
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book with this ID already exists.");
        }
    }

    // Search for a book by title or author
    public void searchBook(String query) {
        System.out.println("Search Results:");
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println(book);
            }
        }
    }

    // Borrow a book
    public void borrowBook(String bookId, String userId) {
        if (books.containsKey(bookId)) {
            Book book = books.get(bookId);
            if (!book.isBorrowed()) {
                book.borrowBook();
                System.out.println("Book borrowed successfully by " + userId);
            } else {
                // Add to waiting queue if the book is already borrowed
                waitList.get(bookId).offer(userId);
                System.out.println("Book is currently borrowed. Added to the waiting list.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Return a book
    public void returnBook(String bookId) {
        if (books.containsKey(bookId)) {
            Book book = books.get(bookId);
            if (book.isBorrowed()) {
                book.returnBook();
                System.out.println("Book returned successfully.");

                // Check the waiting list
                if (!waitList.get(bookId).isEmpty()) {
                    String nextUser = waitList.get(bookId).poll();
                    borrowBook(bookId, nextUser); // Automatically borrow for the next user in queue
                }
            } else {
                System.out.println("This book was not borrowed.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Display all books
    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
