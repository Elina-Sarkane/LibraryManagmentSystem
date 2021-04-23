package entity;

public class Book {
    public String authorName;
    public String bookTitle;
    public int bookAmount;

    public Book(String authorName, String bookTitle, int bookAmount) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookAmount = bookAmount;
    }
}
