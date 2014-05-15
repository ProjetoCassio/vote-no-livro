package com.votenolivro.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import com.votenolivro.bean.EntityTemplate;
import com.votenolivro.bean.IEntity;

/**
 * 
 * @author Cassio Lemos
 * 
 * @param <T>
 */
public class GenericDao<T extends EntityTemplate> implements IDao<T>{

	private DaoFactory daoFactory;
	private Class<T> clazz;

	public GenericDao(Class<T> clazz, DaoFactory daoFactory) {
		this.clazz = clazz;
		this.daoFactory = daoFactory;
	}

	public void save(IEntity entity) {
		Transaction tx = this.daoFactory.getSession().beginTransaction();
		this.daoFactory.getSession().save(entity);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		Criteria criteria = this.daoFactory.getSession().createCriteria(
				this.clazz);
		List<T> entities = criteria.list();
		return entities;
	}

}
