package Library;
import java.io.Serializable;

public class BookClass implements Serializable {
  private int bookId;
  private String title;
  private String author;
  //!Fiction, literature, non fictional poetry
  private String genre;
  private boolean isAvailable;

  //!Display the book details
  public void displayBook() {
    System.out.println("Book id: " + bookId);
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Genre: " + genre);
    System.out.println("Is available: " + isAvailable);
  }

  //!Getters and setters
  public String getTitle() {
    return title;
  }
  public String getAuthor() {
    return author;
  }
  public int getBookId() {
    return bookId;
  }
  public String getGenre() {
    return genre;
  }
  public boolean getIsAvailable() {
    return isAvailable;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public void setIsAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }
}
