package controller;
import entity.Book;
import entity.User;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UserInput userInput = new UserInput();
    BookList bookList = new BookList();

    public void showLibrary() {
        String[] libraryMenu = {"Log in", "View profile", "View book list", "Search books", "Borrow books", "Return books", "Log out"};
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
        } else if (chooseOption == libraryMenu[1]) {
            viewProfile();
        } else if (chooseOption == libraryMenu[2]) {
            viewBooks();
        } else if (chooseOption == libraryMenu[3]) {
            searchBook();
        } else if (chooseOption == libraryMenu[4]) {
            borrowBook();
        } else if (chooseOption == libraryMenu[5]) {
            returnBook();
        } else {
            System.exit(0);
        }
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
    void viewProfile(){
    }
    void viewBooks(){
        ArrayList<Book> allBooks = bookList.getAllBookList();
        System.out.println("Id\tAuthor Name | Book Title | Available amount\n");

        int counter = 0;
        for (Book bookList : allBooks) {
            System.out.println(counter + ". \t" + bookList.authorName + " | " + bookList.bookTitle + " | " + bookList.bookAmount);
            counter++;
        }
    }

    void searchBook(){

    }
    void borrowBook(){
    }
    void returnBook(){
    }
}


    /*
    addUser()
    statistic
    search - title / author

     */

