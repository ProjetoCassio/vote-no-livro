package com.votenolivro.controller.test;

import java.util.ArrayList;
import java.util.List;

import com.votenolivro.bean.Book;
import com.votenolivro.bean.Vote;
import com.votenolivro.controller.CombinationFactory;

import junit.framework.TestCase;

public class CombinationFactoryTest extends TestCase {

	public void testValidCombination() {

		List<Book> books = new ArrayList<Book>();
		List<Vote> votes = new ArrayList<Vote>();

		for (int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setId(new Long(i + 1));
			books.add(book);
		}

		List<Book> newsBooks = null;

		int i = 0;
		do {
			CombinationFactory combinationFactory = new CombinationFactory();
			newsBooks = combinationFactory.getValidCombination(books, votes);
			// calculo simples, se for dinamica a quantidade de livros sera
			// preciso implementar um novo metodo pra ser assertivo na
			// quantidade de combinacoes
			// 1 2, 1 3, 1 4, 1 5
			// 2 3, 2 4, 2 5
			// 3 4, 3 5
			// 4 5
			if (newsBooks != null) {
				Book b1 = newsBooks.get(0);
				Book b2 = newsBooks.get(1);
				System.out.println(b1.getId() + " - " + b2.getId());

				votes.add(new Vote(b1, b2, null, null));
			}

			i++;
		} while (newsBooks != null);

		assertEquals(11, i);

	}

}
