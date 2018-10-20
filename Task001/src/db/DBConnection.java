package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static String DBPath = "jdbc:mysql://localhost/task001";
	public static String login = "root";
	public static String password = "";
	public static Connection con;
	public static Statement st;
	
	public DBConnection(){
		try{
			  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			  Class.forName("com.mysql.jdbc.Driver");
			  con = (Connection) DriverManager.getConnection(DBPath, login, password); 
			  st = con.createStatement();
			  System.out.println("Open DBConnection");
			  
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      
		   }
	}
	
	//close connection with DataBase
	public void closeConnection(){
		try {
			
			con.close();
			System.out.println("Close DBConnection");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
