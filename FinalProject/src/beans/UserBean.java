package beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserBean extends DBUtil {
	private String imagepath;
	private int id;
	private String name;
	private String surname;
	private String city;
	private String address;
	private String phoneno;
	private String email;
	private boolean isright;
	private boolean isdeleted;
	private boolean isadmin;
	private String username;
	private String password;
	private int money;

	public UserBean() {

	}

	public UserBean(String DB_Path, String login, String password) {
		super(DB_Path, login, password);
	}

	public UserBean(int id, String name, String surname, String city, String address, String phoneno, String email, String imagepath, boolean isright, boolean isdeleted, boolean isadmin, String username, String password, int money) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.imagepath = imagepath;
		this.isright = isright;
		this.isdeleted = isdeleted;
		this.isadmin = isadmin;
		this.username = username;
		this.password = password;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsright() {
		return isright;
	}

	public void setIsright(boolean isright) {
		this.isright = isright;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public void AddUser(String name, String surname, String city, String address, String phoneno, String email, String imagepath, String username, String password) {

		try {

			String query = "INSERT INTO users ( name, surname,city,address, phoneno, email, username,password, imagepath,money) VALUES ( ?, ?, ?, ?, ?,?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, phoneno);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, username);
			preparedStmt.setString(8, password);
			preparedStmt.setString(9, imagepath);
			preparedStmt.setInt(10, 0);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean UsernameNotExist(String username) {
		boolean check = true;

		try {

			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					check = false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public boolean UsernameNotExist(int id, String username) {
		boolean check = true;

		try {

			ResultSet rs = stmt.executeQuery("select * from users where id!=" + id);

			while (rs.next()) {
				if (username.equals(rs.getString("username"))) {
					check = false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public boolean IsAdmin(String username) {
		boolean check = false;

		try {

			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				if (username.equals(rs.getString("username")) && rs.getBoolean("isadmin") == true) {
					check = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public boolean CheckUsernamePassword(String username, String password) {
		boolean check = false;

		try {

			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				if (username.equals(rs.getString("username")) && password.equals(rs.getString("password")) && rs.getBoolean("isright") == true && rs.getBoolean("isdeleted") == false) {
					check = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int GetUserIDByUsername(String username) {
		int ID = 0;

		try {

			ResultSet rs = stmt.executeQuery("select * from users where username='" + username + "' limit 1");
			if (rs.next()) {
				ID = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ID;
	}

	public String GetUsernameByID(int id) {
		String user_name = "";

		try {

			ResultSet rs = stmt.executeQuery("select * from users where id='" + id + "' limit 1");
			if (rs.next()) {
				user_name = rs.getString("name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user_name;
	}

	public List<UserBean> getUserById(int id) {

		List<UserBean> list = new ArrayList<UserBean>();
		;

		try {

			ResultSet rs = stmt.executeQuery("select * from users where id=" + id);

			if (rs.next()) {
				list.add(new UserBean(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("city"), rs.getString("address"), rs.getString("phoneno"), rs.getString("email"), rs.getString("imagepath"), rs.getBoolean("isright"),
						rs.getBoolean("isdeleted"), rs.getBoolean("isadmin"), rs.getString("username"), rs.getString("password"), rs.getInt("money")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserBean> getUsers() {

		List<UserBean> list = new ArrayList<UserBean>();
		;

		try {

			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				list.add(new UserBean(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("city"), rs.getString("address"), rs.getString("phoneno"), rs.getString("email"), rs.getString("imagepath"), rs.getBoolean("isright"),
						rs.getBoolean("isdeleted"), rs.getBoolean("isadmin"), rs.getString("username"), rs.getString("password"), rs.getInt("money")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserBean> getUsers(String keyword) {

		List<UserBean> list = new ArrayList<UserBean>();
		;

		try {

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users where name like ? or surname like ? or city like ? or address like ? or phoneno like ? or email like ? or username like ?");
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, "%" + keyword + "%");
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new UserBean(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("city"), rs.getString("address"), rs.getString("phoneno"), rs.getString("email"), rs.getString("imagepath"), rs.getBoolean("isright"),
						rs.getBoolean("isdeleted"), rs.getBoolean("isadmin"), rs.getString("username"), rs.getString("password"), rs.getInt("money")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void Buy(int id, int money) {
		try {
			String query = "UPDATE users SET money = money+'" + money + "' where id='" + id + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ChangeUser(int id, String name, String surname, String city, String address, String phoneno, String email, String imagepath, String username) {

		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE users SET name = ?, surname = ?,city = ?,address = ?, phoneno=? , email=?, username=?, imagepath=? WHERE id=?");

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, phoneno);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, username);
			preparedStmt.setString(8, imagepath);
			preparedStmt.setInt(9, id);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ChangeUser(int id, String name, String surname, String city, String address, String phoneno, String email, String imagepath, String username, String password) {

		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE users SET name = ?, surname = ?,city = ?,address = ?, phoneno=? , email=?, username=?, imagepath=?, password = ? WHERE id=?");

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, phoneno);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, username);
			preparedStmt.setString(8, imagepath);
			preparedStmt.setString(9, password);
			preparedStmt.setInt(10, id);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ChangeUserWithoutImage(int id, String name, String surname, String city, String address, String phoneno, String email, String username) {

		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE users SET name = ?, surname = ?,city = ?,address = ?, phoneno=? , email=?, username=? WHERE id=?");

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, phoneno);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, username);
			preparedStmt.setInt(8, id);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ChangeUserWithoutImage(int id, String name, String surname, String city, String address, String phoneno, String email, String username, String password) {

		try {
			PreparedStatement preparedStmt = conn.prepareStatement("UPDATE users SET name = ?, surname = ?,city = ?,address = ?, phoneno=? , email=?, username=?, password=? WHERE id=?");

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, phoneno);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, username);
			preparedStmt.setString(8, password);
			preparedStmt.setInt(9, id);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void admin(int value, int id) {
		try {
			String query = "UPDATE users SET isadmin='" + value + "' where id='" + id + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void right(int value, int id) {
		try {
			String query = "UPDATE users SET isright='" + value + "' where id='" + id + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int value, int id) {
		try {
			String query = "UPDATE users SET isdeleted='" + value + "' where id='" + id + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}