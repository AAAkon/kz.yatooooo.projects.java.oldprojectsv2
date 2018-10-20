package beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryBean extends DBUtil {
	private int id;
	private String name;

	public CategoryBean() {

	}

	public CategoryBean(int id, String name) {
		this.id = id;
		this.name = name;
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

	public List<CategoryBean> getCategories() {

		List<CategoryBean> list = new ArrayList<CategoryBean>();
		;

		try {

			ResultSet rs = stmt.executeQuery("select * from categories");

			while (rs.next()) {
				list.add(new CategoryBean(rs.getInt("id"), rs.getString("name")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean NotExist(String categoryname) {
		boolean check = true;

		try {

			ResultSet rs = stmt.executeQuery("select * from categories");

			while (rs.next()) {
				if (categoryname.toUpperCase().equals(rs.getString("username").toUpperCase())) {
					check = false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public void AddCategory(String name) {

		try {
			if (NotExist(name) == true) {
				String query = "INSERT INTO categories ( name ) VALUES ( ? )";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				preparedStmt.setString(1, name);
				preparedStmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
