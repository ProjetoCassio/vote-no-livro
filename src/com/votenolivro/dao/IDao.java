package com.votenolivro.dao;

import java.util.List;
import com.votenolivro.bean.EntityTemplate;
import com.votenolivro.bean.IEntity;

/**
 * 
 * @author Cassio Lemos
 *
 * @param <T>
 */
public interface IDao <T extends EntityTemplate>{

	public void save(IEntity entity);
	public List<T> list();
	public T getById(Long id);
	
}
