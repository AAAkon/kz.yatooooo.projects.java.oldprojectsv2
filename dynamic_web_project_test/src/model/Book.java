package model;

import java.sql.Date;

public class Book {
	private int id;
	private String name;
	private String author;
	private int page_number;
	private Date date;

	public Book() {

	}

	public Book(int id, String name, String author, int page_number, Date date) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.page_number = page_number;
		this.date = date;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage_number() {
		return page_number;
	}

	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
