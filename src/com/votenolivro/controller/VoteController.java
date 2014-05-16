package com.votenolivro.controller;

import java.util.Date;
import java.util.List;
import com.votenolivro.bean.Book;
import com.votenolivro.bean.NewResearch;
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
public class VoteController extends AbstractController {

	private NewResearch newResearch;

	public VoteController(Result result, DaoFactory daoFactory,
			NewResearch newResearch) {
		super(daoFactory, result);
		this.newResearch = newResearch;
	}

	public void list() {
		// listar os livros para votacao
		log.info("Carregando listas inicias");
		loadInitialList();

		List<Book> combinations = new CombinationFactory().getValidCombination(
				this.newResearch.getBooksToUser(), this.newResearch.getVotes());

		// acabaram as opcoes, direcionar para parte final
		if (combinations == null) {
			// caso o usuario ainda esteja na sessao, direciona para o final
			if (this.newResearch.getUserExt() != null) {
				log.info("Usuario ok - Redirecionando para o ranking geral");
				this.result.redirectTo(RankingController.class).list();
				return;
			} else {
				log.info("Votacao ok - Redirecionando para formulario do usuario");
				this.result.redirectTo(UserController.class).list();
				return;
			}

		}
		this.newResearch.setBooksInVote(combinations);
		this.result.include("livros", combinations);
	}
	
	private void loadInitialList(){
		if (this.newResearch.getBooksToUser() == null) {
			List<Book> livros = this.daoFactory.getDao(Book.class).list();
			if (livros == null || livros.isEmpty()) {
				LoadInitialData cInicial = new LoadInitialData();
				cInicial.loadBooks(this.daoFactory);
				log.error("Lista de livros nao cadastrada.");
			
			}
			this.newResearch.setBooksToUser(livros);
		}
	}

	/*
	 * Ao salvar o sistema deve persistir o voto verificar a proxima lista e
	 * direcionar para o list se nao tiver mais escolhas, direcionar para uma
	 * nova pagina para pedir o usuario e mostrar o ranking
	 */
	public void save(String id) {
		log.info("Voto realizado, salvando.");
		Book book = this.daoFactory.getDao(Book.class).getById(new Long(id));
		Book otherBook = getOtherBook(this.newResearch.getBooksInVote(),
				new Long(id));

		Vote vote = new Vote(book, otherBook, null, new Date());
		this.newResearch.addVote(vote);
		this.result.redirectTo(VoteController.class).list();

	}

	private Book getOtherBook(List<Book> books, Long selected) {
		for (Book book : books) {
			if (!book.getId().equals(selected)) {
				return book;
			}
		}
		return null;
	}

}
