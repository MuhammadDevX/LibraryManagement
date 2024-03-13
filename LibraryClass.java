package Library;

import java.util.Scanner;

import java.util.ArrayList;

public class LibraryClass {
  private static ArrayList<BookClass> books = new ArrayList<BookClass>();
  private static ArrayList<UserClass> users = new ArrayList<UserClass>();

  public LibraryClass() {
    if (LibraryClass.books.isEmpty()) {
      books = FileHandling.loadBooks("books.txt");
    }

    if (users.isEmpty()) {
      users = FileHandling.loadUsers("users.txt");
    }
  }

  Scanner input = new Scanner(System.in);

  public void addBook() {
    BookClass book = new BookClass();
    System.out.println("Enter the book id:");
    book.setBookId(input.nextInt());
    input.nextLine();
    System.out.println("Enter the title of the book:");
    book.setTitle(input.nextLine());
    System.out.println("Enter the author of the book:");
    book.setAuthor(input.nextLine());

    System.out.println("Enter the genre of the book:");
    book.setGenre(input.nextLine());
    book.setIsAvailable(true);
    books.add(book);
    FileHandling.saveBooks(books, "books.txt");
    System.out.println("Book added successfully");
  }

  public void addUser() {
    UserClass user = new UserClass();
    System.out.println("Enter the user name:");
    user.setUserName(input.nextLine());
    System.out.println("Enter the contact info:");
    user.setContactInfo(input.nextLine());
    System.out.println("Enter the user id:");
    user.setUserId(input.nextInt());
    users.add(user);
    FileHandling.saveUsers(users, "users.txt");
    System.out.println("User added successfully");
  }

  public void checkingOut() {
    FileHandling.loadBooks("books.txt");
    FileHandling.loadUsers("users.txt");
    System.out.println("Enter the user id:");
    int userId = input.nextInt();
    System.out.println("Enter the book id:");
    int bookId = input.nextInt();
    for (UserClass user : users) {
      if (user.getUserId() == userId) {
        for (BookClass book : books) {
          if (book.getBookId() == bookId) {
            if (book.getIsAvailable()) {
              book.setIsAvailable(false);
              user.getBorrowedBooks().add(book);

              System.out.println("Book " + book.getTitle() + " checked out successfully");
              FileHandling.saveBooks(books, "books.txt");
              return;
            } else {
              System.out.println("Book is not available");
              return;
            }
          }
        }
        System.out.println("No book found with this id");
        return;
      }
    }
    System.out.println("No user found with this id");
  }

  public void returningBooks() {
    FileHandling.loadBooks("books.txt");
    FileHandling.loadUsers("users.txt");
    System.out.println("Enter the user id:");
    int userId = input.nextInt();
    System.out.println("Enter the book id:");
    int bookId = input.nextInt();
    for (UserClass user : users) {
      if (user.getUserId() == userId) {
        for (BookClass book : books) {
          if (book.getBookId() == bookId) {
            if (!book.getIsAvailable()) {
              book.setIsAvailable(true);
              user.getBorrowedBooks().remove(book);
              System.out.println("Book returned successfully");
              return;
            } else {
              System.out.println("Book is already available");
              return;
            }
          }
        }
        System.out.println("No book found with this id");
        return;
      }
    }
    System.out.println("No user found with this id");
  }

  public void searchBook() {
    System.out.println("Enter 1 for searching the book by title or 2 for searching the book by author");
    int choice = input.nextInt();

    if (choice == 1) {
      System.out.println("Enter the title of the book");
      String title = input.nextLine();
      for (BookClass book : books) {
        if (book.getTitle().equals(title)) {
          book.displayBook();
          return;
        }
      }
      System.out.println("No book found with this title");
    } else if (choice == 2) {
      System.out.println("Enter the author of the book");
      String author = input.nextLine();
      for (BookClass book : books) {
        if (book.getAuthor().equals(author)) {
          book.displayBook();
          return;
        }
      }
      System.out.println("No book found with this author");
    } else {
      System.out.println("Invalid choice");
    }
  }

  public void displayBooks() {
    for (BookClass book : books) {
      book.displayBook();
    }
  }

  public void searchByUserId() {

    System.out.println("Enter the user id:");
    int userId = input.nextInt();
    for (UserClass user : users) {
      if (user.getUserId() == userId) {

        for (BookClass book : user.getBorrowedBooks()) {
          FileHandling.loadBooks("books.txt");
          book.displayBook();
        }
        return;
      }
    }
    System.out.println("No user found with this id");
  }

  public static ArrayList<UserClass> getUsers() {
    return users;
  }

  public static ArrayList<BookClass> getBooks() {
    return books;
  }

  public static void setBooks(ArrayList<BookClass> books) {
    LibraryClass.books = books;
  }

  public static void setUsers(ArrayList<UserClass> users) {
    LibraryClass.users = users;
  }

}
