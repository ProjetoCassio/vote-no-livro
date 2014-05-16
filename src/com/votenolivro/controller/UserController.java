package com.votenolivro.controller;

import java.util.List;
import com.votenolivro.bean.BookRk;
import com.votenolivro.bean.NewResearch;
import com.votenolivro.bean.UserExt;
import com.votenolivro.bean.Vote;
import com.votenolivro.dao.DaoFactory;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * Controler para validar o usuario "Validacao simples"
 * 
 * @author Cassio Lemos
 * 
 */
@Resource
public class UserController extends AbstractController {

	private NewResearch newResearch;

	public UserController(Result result, DaoFactory daoFactory,
			NewResearch newResearch) {
		super(daoFactory, result);
		this.newResearch = newResearch;
	}

	public void list() {
		// mostrar campos para computar os votos
		log.info("Carregando formulario do usuario");

		CalcRanking cRanking = new CalcRanking();
		List<BookRk> books = cRanking.getRanking(this.newResearch.getVotes());

		this.result.include("books", books);
	}

	@Get("user/save")
	public void save(UserExt userExt) {
		// salvar votos e direcionar para o ranking
		
		if(userExt==null || !userExt.isNotValid()){
			this.result.include("message", "Usuario invalido, preencha todos os campos");
			this.result.redirectTo(UserController.class).list();
		}
		
		log.info("Registrando usuario");
		this.daoFactory.getDao(UserExt.class).save(userExt);

		this.newResearch.setUserExt(userExt);

		for (Vote vote : this.newResearch.getVotes()) {
			this.daoFactory.getDao(Vote.class).save(vote);
		}

		log.info("Redirecionando para o formulario de Ranking");
		this.result.redirectTo(RankingController.class).list();
	}

}
