package beans;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBUtil {
	public static String DB_Path = "";
	public static String login = "";
	public static String password = "";
	public static Connection conn;
	public static Statement stmt;

	public DBUtil(String DB_Path, String login, String password) {

		try {
			System.out.println("HELLO");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_Path, login, password);
			stmt = conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public DBUtil() {

	}

	// return connection
	public Connection getConnection() {
		return this.conn;
	}

	// close connection with DataBase
	public void closeConnection() {
		try {

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
