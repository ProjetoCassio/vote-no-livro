package com.votenolivro.controller;

import com.votenolivro.bean.Book;
import com.votenolivro.dao.DaoFactory;

public class LoadInitialData {

	public void loadBooks(DaoFactory daoFactory) {

		// cadastrar 5 livros
		Book b1 = new Book("Paulo Silveira",
				"Introdução à arquitetura e design de software", "Uma leitura tranquila, falando de metodos e melhores praticas da linguagem Java");
		Book b2 = new Book("Bill Gates",
				"A empresa na velocidade do pensamento", "Bill Gates conta a historia da mais poderosa empresa existente");
		Book b3 = new Book("Ernesto Haberkorn", "Gestão empresarial com ERP",
				"Principais funcionalidades para um completo sistema ERP");
		Book b4 = new Book("Mathew Quick", "O lado bom da vida", "Conta a historia de um homem que tenta recompor sua memoria e enfrentando uma realidade não promissora.");
		Book b5 = new Book(
				"Dan Brown",
				"Ponto de impacto",
				"Uma excelente trama com cenários convincentes e a mistura perfeita de personagens adoraveis e detestaveis.");

		daoFactory.getDao(Book.class).save(b1);
		daoFactory.getDao(Book.class).save(b2);
		daoFactory.getDao(Book.class).save(b3);
		daoFactory.getDao(Book.class).save(b4);
		daoFactory.getDao(Book.class).save(b5);

	}

}
