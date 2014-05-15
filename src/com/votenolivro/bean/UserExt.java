package com.votenolivro.bean;

import javax.persistence.Entity;

/**
 * 
 * @author Cassio Lemos
 * 
 */
@Entity
public class UserExt extends EntityTemplate {

	private String name;
	private String email;

	public UserExt() {
		super();
	}

	public UserExt(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
