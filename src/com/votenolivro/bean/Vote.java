package com.votenolivro.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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

	@Transient
	private Book otherBook;
	
	public Vote() {
		super();
	}

	public Vote(Book book, Book otherBook, UserExt userExt, Date date) {
		super();
		this.book = book;
		this.userExt = userExt;
		this.date = date;
		this.otherBook = otherBook;
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

	public Book getOtherBook() {
		return otherBook;
	}

	public void setOtherBook(Book otherBook) {
		this.otherBook = otherBook;
	}

	/**
	 * Verifica se este voto bate com a combinacao
	 * @param book1 
	 * @param book2 
	 * @return
	 */
	public boolean isVoted(Book book1, Book book2){
		if(
				(this.book.equals(book1) && this.otherBook.equals(book2))
				||
				(this.book.equals(book2) && this.otherBook.equals(book1))
				){
			return true;
		}
		return false;
	}
	
	
}
