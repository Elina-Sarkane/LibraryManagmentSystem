package entity;

public class Book {
    public String authorName;
    public String bookTitle;
    public int bookYear;
    public int bookPageAmount;
    public int bookAmount;

    public Book(String authorName, String bookTitle, int bookYear, int bookPageAmount, int bookAmount) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookYear = bookYear;
        this.bookPageAmount = bookPageAmount;
        this.bookAmount = bookAmount;
    }
}
