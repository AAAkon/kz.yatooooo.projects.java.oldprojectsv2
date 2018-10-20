package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private final String DBPath = "jdbc:mysql://localhost/test_books";
	private final String DBUser = "root";
	private final String DBPassword = "";
	private final String JDBCDriver = "com.mysql.jdbc.Driver";
	protected static Connection connection;
	protected static Statement statement;
	protected static PreparedStatement preparedStatement;
	protected static ResultSet resultSet;
	protected static String sql = "";

	public JDBC() {
		try {
			Class.forName(JDBCDriver);
			connection = DriverManager.getConnection(DBPath, DBUser, DBPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}