package com.votenolivro.bean;

/**
 * Value object para ranking
 * @author Cassio Lemos
 *
 */
public class BookRk implements Comparable<BookRk>{
	
	private Book book;
	private int count;
	
	
	public BookRk(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(BookRk o) {
		if(this.count<o.getCount()){
			return 1;
		}
		if(this.count>o.getCount()){
			return -1;
		}
		return 0;
	}
	
	
	

}
