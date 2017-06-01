package org.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.loja.modelo.Autor;

public class AutorDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Autor> list() {
		return manager.createQuery(
				"select a from Autor a order by a.name asc", Autor.class)
				.getResultList();
	}



}
