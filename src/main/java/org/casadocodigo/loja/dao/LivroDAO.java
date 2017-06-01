package org.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.loja.modelo.Livro;

public class LivroDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Livro produto) {

		manager.persist(produto);

	}

	public List<Livro> list() {
		return manager.createQuery("select distinct(b) from Livro b join fetch b.autores", Livro.class).getResultList();
	}

}
