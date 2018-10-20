package entities;

public class UserBean{
	private int id;
	private String fname;
	private String lname;

	public UserBean(int id, String fname, String lname){
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}
	
	//Getter Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
