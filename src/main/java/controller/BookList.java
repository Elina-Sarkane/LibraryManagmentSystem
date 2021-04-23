package controller;

import entity.Book;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getAllBookList(){
        books.add(new Book("Veronica Roth", "'Divergent'", 2011, 487, 6));
        books.add(new Book("Veronica Roth", "'Insurgent'", 2012, 525, 2));
        books.add(new Book("Veronica Roth", "'Allegiant'", 2013, 526,  1));
        books.add(new Book("Lauren Kate", "'Fallen'", 2009, 452, 7));
        books.add(new Book("Lauren Kate", "'Torment'", 2010, 452, 4));
        books.add(new Book("Alan Alexander Milne", "'Winnie the Pooh'", 1926, 176,  5));
        books.add(new Book("Roald Dahl", "'Charlie and the Chocolate Factory'", 1979, 192, 8));
        return books;
    }
}
