package Library;

import java.util.ArrayList;
import java.io.Serializable;
public class UserClass  implements Serializable{
  private int userId;
  private String userName;
  private String contactInfo;
  private static ArrayList<BookClass> borrowedBooks = new ArrayList<BookClass>();

  public ArrayList<BookClass> getBorrowedBooks(){
    return borrowedBooks;
  }

  public void dsiplayBorrowedBooks() {
    for(BookClass book : borrowedBooks){
      book.displayBook();
    }
  }
  public String getContactInfo() {
    return contactInfo;
  }
  public int getUserId() {
    return userId;
  }
  public String getUserName() {
    return userName;
  }
  // public void setBorrowedBooks(ArrayList<String> borrowedBooks) {
  //   borrowedBooks = borrowedBooks;
  // }
  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
}
