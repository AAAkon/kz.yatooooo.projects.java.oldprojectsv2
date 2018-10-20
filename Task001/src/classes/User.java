package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.DBConnection;
import entities.UserBean;

public class User extends DBConnection{
	private UserBean user;
	
	public User(){
		
	}
	
	public void Add(int id,String fname,String lname){
		
			try {
				DBConnection db = new DBConnection();//open
				
				String query = "INSERT INTO users ( id, fname, lname) VALUES ( ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);				
				preparedStmt.setInt (1, id);
			  	preparedStmt.setString (2, fname);
			  	preparedStmt.setString (3, lname);
		  		preparedStmt.executeUpdate();
		  		
		  		db.closeConnection();//close
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public UserBean Find(int id){
		
		try{
			DBConnection db = new DBConnection();//open
			
            ResultSet rs = st.executeQuery("select * from users where id="+id);
            
            if(rs.next())
            {
            	user = new UserBean(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"));
            }
            
            db.closeConnection();//close
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
	}
}
