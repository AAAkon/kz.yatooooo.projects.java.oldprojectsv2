package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Book;

public class BookDao extends JDBC {

	public BookDao() {
		super();
	}

	public void add(String name, String author, String page_number_str, String date_str) {
		try {
			int page_number = Integer.parseInt(page_number_str);
			// String to java.util.Date
			// java.util.Date to java.sql.Date
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = format.parse(date_str);
			java.sql.Date date = new java.sql.Date(utilDate.getTime());

			sql = "insert into books(name, author, page_number, date) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			System.out.println(preparedStatement);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setInt(3, page_number);
			preparedStatement.setDate(4, date);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		sql = "select * from books";

		try {
			statement = connection.createStatement();
			if (statement.execute(sql)) {
				resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String author = resultSet.getString("author");
					int page_number = resultSet.getInt("page_number");
					Date date = resultSet.getDate("date");
					books.add(new Book(id, name, author, page_number, date));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
}
