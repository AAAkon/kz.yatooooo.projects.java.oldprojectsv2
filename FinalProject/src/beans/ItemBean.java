package beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ItemBean extends DBUtil{
	private int id;
	private String name;
	private String description;
	private String imagepath;
	private int price;
	private Timestamp date;
	private int amount;
	private boolean isdeleted;
	private String categoryname;
	private String user_name;
	private int user_id;
	
	
	
	public ItemBean(int id, String name, String description, String imagepath, int price, Timestamp date, int amount,
			boolean isdeleted, String categoryname, String user_name, int user_id) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.imagepath = imagepath;
		this.price = price;
		this.date = date;
		this.amount = amount;
		this.isdeleted = isdeleted;
		this.categoryname = categoryname;
		this.user_name = user_name;
		this.user_id = user_id;
	}
	
	public ItemBean() {
		
	}
	
	public ItemBean(String DB_Path, String login, String password) {
		super(DB_Path, login, password);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public void AddItem(String name,String description,String imagepath,int price,int amount,String categoryname,String user_name,int user_id){
		
		try {
		  
			String query = "INSERT INTO items ( name, description,imagepath,price, date, amount, categoryname, user_name,user_id) VALUES ( ?, ?, ?, ?, ?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);		
			preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString (1, name);
		  	preparedStmt.setString (2, description);
		  	preparedStmt.setString (3, imagepath);
		  	preparedStmt.setInt (4, price);
		  	preparedStmt.setTimestamp (5, new java.sql.Timestamp(System.currentTimeMillis()));
	  		preparedStmt.setInt (6, amount);
	  		preparedStmt.setString (7, categoryname);
	  		preparedStmt.setString (8, user_name);
	  		preparedStmt.setInt (9, user_id);
	  		preparedStmt.executeUpdate();
	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ItemBean> getItems(){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
            ResultSet rs = stmt.executeQuery("select * from items where isdeleted = 0");
            
            while(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public List<ItemBean> getItemById(int item_id){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
            ResultSet rs = stmt.executeQuery("select * from items where id="+item_id+" and isdeleted = 0");
            
            if(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public List<ItemBean> getItemByUserid(int user_id){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
            ResultSet rs = stmt.executeQuery("select * from items where user_id="+user_id+" and isdeleted = 0");
            
            while(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public List<ItemBean> getItemByKeyword(String keyword){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
        	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM items where name like ? or description like ? or user_name like ? and isdeleted = 0");
        	pstmt.setString(1, "%" + keyword+"%");
        	pstmt.setString(2, "%" + keyword+"%");
        	pstmt.setString(3, "%" + keyword+"%");
        	ResultSet rs = pstmt.executeQuery();
        	
            while(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public List<ItemBean> getItemByCategory(String category){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
        	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM items where categoryname like ?  and isdeleted = 0");
        	pstmt.setString(1, "%" + category+"%");
        	ResultSet rs = pstmt.executeQuery();
        	
            while(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public List<ItemBean> getItemByCategoryAndKeyword(String category,String keyword){
		
	 	List<ItemBean> list = new ArrayList<ItemBean>();;
	 	
        try{
            
        	PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM items where categoryname like ? and (name like ? or description like ? or user_name like ? ) and isdeleted = 0");
        	pstmt.setString(1, "%" + category+"%");
        	pstmt.setString(2, "%" + keyword+"%");
        	pstmt.setString(3, "%" + keyword+"%");
        	pstmt.setString(4, "%" + keyword+"%");
        	ResultSet rs = pstmt.executeQuery();
        	
            while(rs.next())
            {
            	list.add(new ItemBean(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("imagepath"),rs.getInt("price"),rs.getTimestamp("date"),rs.getInt("amount"),rs.getBoolean("isdeleted"),rs.getString("categoryname"),rs.getString("user_name"),rs.getInt("user_id"))); 
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public void Buy(int id, int amount){
		
		try {
			String query = "UPDATE items SET amount = amount - '"+amount+"' where id='"+id+"'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
	  		preparedStmt.executeUpdate();
	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteItem(int id){
		try {
			System.out.println("id: "+id);
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE items SET isdeleted=1 where id="+id+"");
	  		preparedStmt.executeUpdate();
	  		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ChangeItem(int id,String name,String description,String imagepath, int price,int amount,String categoryname){
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE items SET name = ?, description = ?,imagepath = ?,price = ?, amount=? , categoryname=? WHERE id=?");
        	
			
			preparedStmt.setString (1, name);
		  	preparedStmt.setString (2, description);
		  	preparedStmt.setString (3, imagepath);
		  	preparedStmt.setInt (4, price);
		  	preparedStmt.setInt (5, amount);
	  		preparedStmt.setString (6, categoryname);
	  		preparedStmt.setInt (7, id);
	  		preparedStmt.executeUpdate();
	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ChangeItem(int id,String name,String description, int price,int amount,String categoryname){
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE items SET name = ?, description = ?,price = ?, amount=? , categoryname=? WHERE id=?");
        	
			
			preparedStmt.setString (1, name);
		  	preparedStmt.setString (2, description);
		  	preparedStmt.setInt (3, price);
		  	preparedStmt.setInt (4, amount);
	  		preparedStmt.setString (5, categoryname);
	  		preparedStmt.setInt (6, id);
	  		preparedStmt.executeUpdate();
	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
