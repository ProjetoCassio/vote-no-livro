package com.votenolivro.controller;

import java.util.List;
import com.votenolivro.bean.BookRk;
import com.votenolivro.bean.Vote;
import com.votenolivro.dao.DaoFactory;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * Controller para mostrar o ranking de votacao
 * @author Cassio Lemos
 *
 */
@Resource
public class RankingController extends AbstractController{
	
	public RankingController(DaoFactory daoFactory, Result result) {
		super(daoFactory, result);
	}

	public void list(){
		//listar livros em ordem de pontuacao
		log.info("Carregando ranking de livros");
		List<Vote> votes = this.daoFactory.getDao(Vote.class).list();
		CalcRanking cRanking = new CalcRanking();
		List<BookRk> books = cRanking.getRanking(votes);
		
		this.result.include("books", books);
		
	}

}
