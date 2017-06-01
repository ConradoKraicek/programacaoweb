package org.casadocodigo.loja.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.casadocodigo.loja.dao.LivroDAO;
import org.casadocodigo.loja.modelo.Livro;

@Model
public class AdminListLivroBean {

	@Inject
	private LivroDAO livroDAO;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	@PostConstruct
	private void loadObjects(){
		this.livros = livroDAO.list();
	}

	public List<Livro> getLivros() {
		return livros;
	}
	
	
}
