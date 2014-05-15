package com.votenolivro.bean;

import javax.persistence.Entity;

/**
 * 
 * @author Cassio Lemos
 * 
 */
@Entity
public class Book extends EntityTemplate {

	private String author;
	private String title;
	private String description;
	private String imageId;

	public Book() {
		super();
	}

	public Book(String author, String title, String description) {
		super();
		this.author = author;
		this.title = title;
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}


@Override
public boolean equals(Object o){
	Book rec = (Book) o;
	if(rec.id.equals(this.id)){
		return true;
	}
	return false;
}
	
	
}
