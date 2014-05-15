package com.votenolivro.bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * 
 * @author Cassio Lemos
 * 
 */
@Entity
public class Vote extends EntityTemplate {

	@OneToOne
	private Book book;
	@OneToOne
	private UserExt userExt;
	private Date date;

	public Vote() {
		super();
	}

	public Vote(Book book, UserExt userExt, Date date) {
		super();
		this.book = book;
		this.userExt = userExt;
		this.date = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UserExt getUserExt() {
		return userExt;
	}

	public void setUserExt(UserExt userExt) {
		this.userExt = userExt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
