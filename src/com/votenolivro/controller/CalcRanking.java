package com.votenolivro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.votenolivro.bean.Book;
import com.votenolivro.bean.BookRk;
import com.votenolivro.bean.Vote;

/**
 * Calcula a partir de uma lista de votos qual o livro mais votado
 * 
 * @author Cassio Lemos
 * 
 */
public class CalcRanking {

	public List<BookRk> getRanking(List<Vote> votes) {
		HashMap<Book, Integer> ranking = new HashMap<Book, Integer>();
		List<BookRk> listPont = new ArrayList<BookRk>();
		
		if (votes!=null) {
			for (Vote vote : votes) {
				if (ranking.containsKey(vote.getBook())) {
					int pont = ranking.get(vote.getBook());
					ranking.put(vote.getBook(), pont + 1);
				} else {
					ranking.put(vote.getBook(), 1);
				}
			}
		}
		for (Book book : ranking.keySet()) {
			listPont.add(new BookRk(book, ranking.get(book)));
		}
		
		Collections.sort(listPont);
		return listPont;
	}
	


}
