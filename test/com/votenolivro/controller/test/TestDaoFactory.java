package com.votenolivro.controller.test;

import com.votenolivro.bean.Book;
import com.votenolivro.dao.DaoFactory;
import com.votenolivro.dao.GenericDao;

import junit.framework.TestCase;

public class TestDaoFactory extends TestCase{

	public void testDaoFactory(){
		
		GenericDao<Book> daoLivro = new GenericDao<>(Book.class, new DaoFactory());
		assertNotNull(daoLivro.list());
		
	}
	
	
}

