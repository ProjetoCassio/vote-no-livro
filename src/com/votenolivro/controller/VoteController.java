package com.votenolivro.controller;

import java.util.Date;
import java.util.List;

import com.votenolivro.bean.Book;
import com.votenolivro.bean.UserExt;
import com.votenolivro.bean.Vote;
import com.votenolivro.dao.DaoFactory;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * 
 * @author Cassio Lemos
 *
 */
@Resource
public class VoteController extends AbstractController{

	
	public VoteController(Result result, DaoFactory daoFactory){
		super(daoFactory, result);
	}
	
	public void list(){
		//listar os livros para votacao
		List<Book> livros = this.daoFactory.getDao(Book.class).list();
		
//		Book book1 = new Book("Cassio", "Livro 1", "Descrição do livro");
//		Book book2 = new Book("Cassio", "Livro 2", "Descrição do livro 2");
//		
//		this.daoFactory.getDao(Book.class).save(book1);
//		this.daoFactory.getDao(Book.class).save(book2);
//
//		UserExt user = new UserExt("Usuario", "cassiodsl@gmail.com");
//		
//		this.daoFactory.getDao(UserExt.class).save(user);
//		
//		Vote vote = new Vote(book1, user, new Date());
//		this.daoFactory.getDao(Vote.class).save(vote);
//		
//		Vote vote2 = new Vote(book2, user, new Date());
//		this.daoFactory.getDao(Vote.class).save(vote2);
//		
//		Vote vote3 = new Vote(book2, user, new Date());
//		this.daoFactory.getDao(Vote.class).save(vote3);
		
		this.result.include("livros", livros);
	}
	
}
