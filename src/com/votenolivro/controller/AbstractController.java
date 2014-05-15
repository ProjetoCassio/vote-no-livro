package com.votenolivro.controller;

import org.apache.log4j.Logger;
import br.com.caelum.vraptor.Result;
import com.votenolivro.dao.DaoFactory;

/**
 * 
 * @author Cassio Lemos
 *
 */
public class AbstractController implements IController{

	protected DaoFactory daoFactory;
	protected Result result;
	static Logger log = Logger.getLogger(AbstractController.class.getName());
	
	public AbstractController(DaoFactory daoFactory, Result result){
		this.daoFactory = daoFactory;
		this.result = result;
	}
	
}
