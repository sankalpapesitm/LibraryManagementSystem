import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add book
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(bookId, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    // Search book
                    System.out.print("Enter book title or author to search: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;

                case 3:
                    // Borrow book
                    System.out.print("Enter Book ID: ");
                    String borrowBookId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    library.borrowBook(borrowBookId, userId);
                    break;

                case 4:
                    // Return book
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    library.returnBook(returnBookId);
                    break;

                case 5:
                    // Display all books
                    library.displayBooks();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}

