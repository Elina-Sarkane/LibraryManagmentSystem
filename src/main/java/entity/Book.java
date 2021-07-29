package entity;

public class Book {
    public int id;
    public String authorName;
    public String bookTitle;
    public int bookYear;
    public int bookPageAmount;
    public int bookAmount;

    public Book(int id, String authorName, String bookTitle, int bookYear, int bookPageAmount, int bookAmount) {
        this.id = id;
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookYear = bookYear;
        this.bookPageAmount = bookPageAmount;
        this.bookAmount = bookAmount;
    }
    public Book(){

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public int getBookPageAmount() {
        return bookPageAmount;
    }

    public void setBookPageAmount(int bookPageAmount) {
        this.bookPageAmount = bookPageAmount;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    @Override
    public String toString() {
        return id +
                "\t" + authorName +
                " | " + "'" + bookTitle + "'" +
                " | " + bookYear +
                " | " + bookPageAmount +
                " | " + bookAmount + "\n";
    }
}
