package kz.iitu.javaee.labs.librarysystem.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Entity
public class BookReturn {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	public Long id;
	
	@ManyToOne
	public User user;
	
	@ManyToOne
	public Book book;
	
	public Timestamp date;
	public int status;
	

	public static int STATUS_PENDING = 1;
	public static int STATUS_ACCEPTED = 2;
	public static int STATUS_PENALTY = 3;
	
	public int getStatusCodePending() {
		return STATUS_PENDING;
	}
	
	public int getStatusCodePenalty() {
		return STATUS_PENALTY;
	}
	
	public int getStatusCodeAccepted() {
		return STATUS_ACCEPTED;
	}
	
	public String getCertainStatusString(int status) {
		if (status == STATUS_PENDING) {
			return "In process";
		} else if (status == STATUS_PENALTY) {
			return "Penalty";
		} else if (status == STATUS_ACCEPTED) {
			return "Accepted by admin";
		} else {
			return null;
		}
	}
	
	public String getStatusString() {
		return getCertainStatusString(status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public String getLeftDate() {
		if (date != null) {
			return Utils.getLeftDateString(date, new Timestamp(System.currentTimeMillis()));
		} else {
			return "";
		}
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
