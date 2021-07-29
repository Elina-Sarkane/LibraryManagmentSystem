package repository;

import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryRepository {
    private DBHandler dbHandler = new DBHandler();

    public void addBookToDB(Book book) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO books (author, title, year, pages, amount) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.authorName);
        preparedStatement.setString(2, book.bookTitle);
        preparedStatement.setInt(3, book.bookYear);
        preparedStatement.setInt(4, book.bookPageAmount);
        preparedStatement.setInt(5, book.bookAmount);

        preparedStatement.execute();
    }

    public ArrayList<Book> getAllBooksFromDatabase() throws SQLException{
        ArrayList<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM books";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            bookList.add(new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("author"),
                    resultSet.getString("title"),
                    resultSet.getInt("year"),
                    resultSet.getInt("pages"),
                    resultSet.getInt("amount")
            ));
        }
        return bookList;
    }

    public Book getSingleBookFromDB(int bookId) throws SQLException{
        Book book = null;
        String query = "SELECT * FROM books WHERE id = " + bookId;
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            book = new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("author"),
                    resultSet.getString("title"),
                    resultSet.getInt("year"),
                    resultSet.getInt("pages"),
                    resultSet.getInt("amount")
            );
        }
        return book;
    }

    public void deleteBook(int bookId) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM books WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);

        preparedStatement.execute();
    }

    public void updateAuthor(int bookId, String newAuthor) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE books SET author = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newAuthor);
        preparedStatement.setInt(2, bookId);

        preparedStatement.execute();
    }
    public void updateTitle(int bookId, String newTitle) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE books SET title = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newTitle);
        preparedStatement.setInt(2, bookId);

        preparedStatement.execute();
    }
    public void updateYear(int bookId, int newYear) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE books SET year = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, newYear);
        preparedStatement.setInt(2, bookId);

        preparedStatement.execute();
    }
    public void updatePages(int bookId, int newPages) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE books SET pages = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, newPages);
        preparedStatement.setInt(2, bookId);

        preparedStatement.execute();
    }
    public void updateAmount(int bookId, int newAmount) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE books SET amount = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, newAmount);
        preparedStatement.setInt(2, bookId);

        preparedStatement.execute();
    }

}
