package Library;

import java.util.Scanner;
import java.util.ArrayList;

public class MainClass {

  public static void main(String[] args) {
    LibraryClass library = new LibraryClass();
    MainClass mainClass = new MainClass();

    ArrayList<BookClass> books = FileHandling.loadBooks("books.txt");
    ArrayList<UserClass> users = FileHandling.loadUsers("users.txt");
    if (books != null) {
      LibraryClass.setBooks(books);
    }
    if (users != null) {
      LibraryClass.setUsers(users);
    }
    int choice = 0;
    Scanner input = new Scanner(System.in);
    while (choice != 7) {
      mainClass.displayMenu();

      System.out.println("Enter your choice:");
      if (input.hasNextInt()) {

      } else {
        input.nextLine();
      }
      choice = input.nextInt();
      switch (choice) {
        case 1:
          library.addBook();

          break;
        case 2:
          library.addUser();
          break;
        case 3:
          library.displayBooks();
          break;
        case 4:
          library.checkingOut();
          break;
        case 5:
          library.returningBooks();
          break;
        case 6:
          library.searchByUserId();
          break;
        case 7:
          System.out.println("Exiting the program");
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    }
    // FileHandling.saveBooks(LibraryClass.getBooks(), "books.ser");
    // FileHandling.saveUsers(LibraryClass.getUsers(), "users.ser");

    input.close();
  }

  public void displayMenu() {
    System.out.println("1. Add a book");
    System.out.println("2. Add a user");
    System.out.println("3. Displaying book");
    System.out.println("4. Borrowing or Checking out books");
    System.out.println("5. Returning books");
    System.out.println("6. Searching For Books by user id");
    System.out.println("7. Exit");
  }
}
