package controller;

import entity.Book;
import entity.User;
import repository.LibraryRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserInput userInput = new UserInput();
    LibraryController libraryController = new LibraryController();
    LibraryRepository libraryRepository = new LibraryRepository();
    Menu menu = new Menu();

    public void logInOptions(){
        String[] logIn = {"User", "Librarian", "Exit"};
        ImageIcon library = new ImageIcon("library.jpg");
        String chooseOption = (String) JOptionPane.showInputDialog(
                null,
                "Choose option:",
                "Welcome to the Library!",
                JOptionPane.INFORMATION_MESSAGE,
                library,
                logIn,
                logIn[0]
        );
        if (chooseOption == logIn[0]){
            showUserLibrary();
        }else if (chooseOption == logIn[1]){
            showLibrary();
        }else {
            System.exit(0);
        }
    }

    //menu for librarian
    public void showLibrary(){
        String[] libraryMenu = {"Add books", "View all books", "View single book", "Update book list", "Remove book", "Exit"};
        ImageIcon library = new ImageIcon("library.jpg");
        String chooseOption = (String) JOptionPane.showInputDialog(
                null,
                "Choose option:",
                "Welcome to the Library!",
                JOptionPane.INFORMATION_MESSAGE,
                library,
                libraryMenu,
                libraryMenu[0]
        );

        if (chooseOption == libraryMenu[0]) {
            libraryController.addBook();
            showLibrary();
        } else if (chooseOption == libraryMenu[1]) {
            libraryController.viewAllBooks();
            showLibrary();
        } else if (chooseOption == libraryMenu[2]) {
            libraryController.viewSingleBook();
            showLibrary();
        } else if (chooseOption == libraryMenu[3]) {
            libraryController.updateBook();
            showLibrary();
        }else if (chooseOption == libraryMenu[4]){
            libraryController.removeBook();
            showLibrary();
        } else {
            System.out.println("Enter 1 to exit, or 2 to show main menu");
            if(scanner.nextLine().equals("1")) {
                System.exit(0);
            }
            logInOptions();
        }
        System.out.println("Press enter to continue");
    }

    //menu for user
    public void showUserLibrary() {
        String[] libraryMenu = {"Log in", "View book list", "Search books", "Borrow books", "Return books", "Log out"};
        ImageIcon library = new ImageIcon("library.jpg");
        String chooseOption = (String) JOptionPane.showInputDialog(
                null,
                "Choose option:",
                "Welcome to the Library!",
                JOptionPane.INFORMATION_MESSAGE,
                library,
                libraryMenu,
                libraryMenu[0]
        );

        if (chooseOption == libraryMenu[0]) {
            logIn();
            showUserLibrary();
        } else if (chooseOption == libraryMenu[1]) {
            libraryController.viewAllBooks();
            showUserLibrary();
        } else if (chooseOption == libraryMenu[2]) {
            libraryController.searchBook();
            showUserLibrary();
        } else if (chooseOption == libraryMenu[3]) {
            libraryController.borrowBook();
            showUserLibrary();
        } else if (chooseOption == libraryMenu[4]) {
            libraryController.returnBook();
            showUserLibrary();
        } else {
            System.out.println("Enter 1 to exit, or 2 to show main menu");
            if(scanner.nextLine().equals("1")) {
                System.exit(0);
            }
            logInOptions();
        }
        System.out.println("Press enter to continue");
    }

    private void logIn(){
        System.out.println("Enter User Name: ");
        String userName = scanner.nextLine();
        System.out.println("Enter User Email: ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = scanner.nextLine();

        User user = new User(userName, userEmail, userPassword);
        System.out.println(userInput.createUser(user));
    }

    public void searchBook(){
        String[] searchBook = {"Author", "Title", "Year", "Exit"};
        ImageIcon book = new ImageIcon("book.jpg");
        String chooseSearchOption = (String) JOptionPane.showInputDialog(
                null,
                "Search by:",
                "Search in the Library!",
                JOptionPane.INFORMATION_MESSAGE,
                book,
                searchBook,
                searchBook[0]
        );
        try {
            if (chooseSearchOption == searchBook[0]) {
                System.out.println("\nSearch by author name: ");
                String authorName = scanner.nextLine();
                System.out.println("Books found: ");

                for (Book bookList : libraryRepository.getAllBooksFromDatabase()) {
                    if (bookList.authorName.toLowerCase().contains(authorName)) {
                        System.out.println(bookList.authorName + " | " + bookList.bookTitle + " | " + bookList.bookYear + " | " + bookList.bookPageAmount + " | " + bookList.bookAmount);
                    }
                }
            } else if (chooseSearchOption == searchBook[1]){
                System.out.println("\nSearch by book title: ");
                String bookName = scanner.nextLine();
                System.out.println("Books found: ");

                for (Book bookList : libraryRepository.getAllBooksFromDatabase()) {
                    if (bookList.bookTitle.toLowerCase().contains(bookName)) {
                        System.out.println(bookList.authorName + " | " + bookList.bookTitle + " | " + bookList.bookYear + " | " + bookList.bookPageAmount + " | " + bookList.bookAmount);
                    }

                }
            }else if (chooseSearchOption == searchBook[2]){

            }else {
                System.out.println("Enter 1 to exit, or 2 to show main menu");
                if (scanner.nextLine().equals("1")) {
                    System.exit(0);
                }
                menu.showUserLibrary();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
