package com.votenolivro.bean;

import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * Bean para navegar na sessao, conhecimento das acoes e entidades
 * em execucao
 * @author Cassio Lemos
 * 
 */
@SessionScoped
@Component
public class NewResearch {

	private UserExt userExt;
	private List<Vote> votes;
	private List<Book> booksToUser;
	private List<Book> booksInVote;

	public NewResearch(){
		
	}
	
	public NewResearch(UserExt userExt, List<Vote> votes) {
		super();
		this.userExt = userExt;
		this.votes = votes;
	}

	public List<Book> getBooksInVote() {
		return booksInVote;
	}

	public void setBooksInVote(List<Book> booksInVote) {
		this.booksInVote = booksInVote;
	}

	public UserExt getUserExt() {
		return userExt;
	}

	public void setUserExt(UserExt userExt) {
		//alterar o usuario de todos os votos
		//especificacao de identificacao do usuario para ultima parte
		if (this.votes!=null) {
			for (Vote vote : this.votes) {
				vote.setUserExt(userExt);
			}
		}
		this.userExt = userExt;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public List<Book> getBooksToUser() {
		return booksToUser;
	}

	public void setBooksToUser(List<Book> booksToUser) {
		this.booksToUser = booksToUser;
	}

	public void addVote(Vote vote) {
		if (this.votes == null) {
			this.votes = new ArrayList<Vote>();
		}
		this.votes.add(vote);
	}

}
