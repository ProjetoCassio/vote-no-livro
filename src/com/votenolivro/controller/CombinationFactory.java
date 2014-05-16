package com.votenolivro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.votenolivro.bean.Book;
import com.votenolivro.bean.Vote;

/**
 * 
 * @author Cassio
 * 
 */
public class CombinationFactory {

	/**
	 * De acordo com os livros disponiveis e combinacoes ja realizadas, retorna
	 * uma nova ou null caso todas tenham sido enviadas
	 * 
	 * @return
	 */
	public List<Book> getValidCombination(List<Book> books, List<Vote> votes) {
		List<Book> listBookFiltered = new ArrayList<Book>();
		
		if (books == null) {
			return null;
		}

		//baguncar lista para animar a brincadeira
		Collections.shuffle(books);
		
		for (Book book1 : books) {

			for (Book book2 : books) {

				if (!isVoted(book1, book2, votes)) {
					if(book1.equals(book2)){
						continue;
					}
					listBookFiltered.add(book1);
					listBookFiltered.add(book2);
					return listBookFiltered;
				}

			}

		}

		return null;
	}

	/**
	 * Verifica se existe um voto com a combinacao de livros
	 * 
	 * @param book1
	 * @param book2
	 * @param votes
	 * @return
	 */
	private boolean isVoted(Book book1, Book book2, List<Vote> votes) {
		if (votes == null) {
			return false;
		}

		for (Vote vote : votes) {
			if (vote.isVoted(book1, book2)) {
				return true;
			}
		}
		return false;
	}

}
