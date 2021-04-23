package controller;

import entity.Book;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getAllBookList(){
        books.add(new Book("Veronica Roth", "Divergent", 6));
        books.add(new Book("Veronica Roth", "Insurgent", 2));
        books.add(new Book("Veronica Roth", "Allegiant", 1));
        books.add(new Book("Lauren Kate", "Fallen", 7));
        books.add(new Book("Lauren Kate", "Torment", 4));
        books.add(new Book("Alan Alexander Milne", "Winnie the Pooh", 5));
        books.add(new Book("Hans Christian Andersen", "The Little Mermaid", 8));
        return books;
    }
}
