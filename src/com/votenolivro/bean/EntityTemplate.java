package com.votenolivro.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Cassio Lemos
 * 
 */
@MappedSuperclass
public abstract class EntityTemplate implements IEntity{

	@Id
	@GeneratedValue
	public Long id;
	
}
