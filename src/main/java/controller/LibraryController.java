package controller;

import entity.Book;
import repository.LibraryRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryController {
    LibraryRepository libraryRepository = new LibraryRepository();
    Scanner scanner = new Scanner(System.in);

    public void addBook(){
        Book book =  collectBookInfo();

        try {
            libraryRepository.addBookToDB(book);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void viewAllBooks(){
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            bookList = libraryRepository.getAllBooksFromDatabase();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        displayBookList(bookList);
    }
    public void viewSingleBook(){
        Book book = null;
        int bookId = Integer.parseInt(getUserInput("ID of book you want to view:"));
        try {
            System.out.println("Id\tAuthor Name | Book Title | Publication year | Pages | Available amount\n");
            book = libraryRepository.getSingleBookFromDB(bookId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(book);
    }
    public void removeBook(){
        int bookId = Integer.parseInt(getUserInput("ID of book you want to delete:"));
        try {
            libraryRepository.deleteBook(bookId);
            System.out.println("Book removed successfully!");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void returnBook(){}
    public void borrowBook(){}

    public void updateBook(){
        int bookId = Integer.parseInt(getUserInput("ID of book you want to update"));
        String[] libraryMenu = {"Author", "Title", "Year", "Pages", "Amount", "Exit"};
        ImageIcon library = new ImageIcon("update.jpeg");
        String chooseOption = (String) JOptionPane.showInputDialog(
                null,
                "Update:",
                "Update books",
                JOptionPane.INFORMATION_MESSAGE,
                library,
                libraryMenu,
                libraryMenu[0]
        );

        try {
            if(chooseOption == libraryMenu[0]){
                System.out.println("Enter author:");
                String newAuthor = scanner.nextLine();
                libraryRepository.updateAuthor(bookId, newAuthor);
                System.out.println("Book author changed successfully!");
            } else if (chooseOption == libraryMenu[1]){
                System.out.println("Enter title:");
                String newTitle = scanner.nextLine();
                libraryRepository.updateTitle(bookId, newTitle);
                System.out.println("Book title changed successfully!");
            } else if (chooseOption == libraryMenu[2]){
                System.out.println("Enter year:");
                Integer newYear = Integer.parseInt(scanner.nextLine());
                libraryRepository.updateYear(bookId, newYear);
                System.out.println("Book year changed successfully!");
            } else if (chooseOption == libraryMenu[3]){
                System.out.println("Enter pages:");
                Integer newPages = Integer.parseInt(scanner.nextLine());
                libraryRepository.updatePages(bookId, newPages);
                System.out.println("Book pages changed successfully!");
            } else if (chooseOption == libraryMenu[4]){
                System.out.println("Enter amount:");
                Integer newAmount = Integer.parseInt(scanner.nextLine());
                libraryRepository.updateAmount(bookId, newAmount);
                System.out.println("Book amount changed successfully!");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    private Book collectBookInfo(){
        Book book = new Book();
        book.setAuthorName(getUserInput("book author:"));
        book.setBookTitle(getUserInput("book title:"));
        book.setBookYear(Integer.parseInt(getUserInput("publication year:")));
        book.setBookPageAmount(Integer.parseInt(getUserInput("book pages:")));
        book.setBookAmount(Integer.parseInt(getUserInput("quantity:")));

        return book;
    }
    private String getUserInput(String info){
        return JOptionPane.showInputDialog("Enter " + info);
    }
    private void displayBookList(ArrayList<Book> bookList){
        System.out.println("\tAll available books");
        System.out.println("Id\tAuthor Name | Book Title | Publication year | Pages | Available amount\n");
        bookList.forEach(System.out::println);
    }

    public void searchBook() { }
}
