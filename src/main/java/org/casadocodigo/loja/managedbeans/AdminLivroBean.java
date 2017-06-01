package org.casadocodigo.loja.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.casadocodigo.loja.dao.AutorDAO;
import org.casadocodigo.loja.dao.LivroDAO;
import org.casadocodigo.loja.infra.MessagesHelper;
import org.casadocodigo.loja.modelo.Autor;
import org.casadocodigo.loja.modelo.Livro;

@Model
public class AdminLivroBean {

	private Livro produto = new Livro();

	private List<Autor> autores = new ArrayList<Autor>();

	private List<Integer> selectedAutoresIds = new ArrayList<>();

	@Inject
	private LivroDAO livroDAO;

	@Inject
	private AutorDAO autorDAO;

	@Inject
	private MessagesHelper messagesHelper;

	@PostConstruct
	public void loadObjects() {

		this.autores = autorDAO.list();
	}

	public Livro getProduto() {

		return produto;

	}

	public List<Autor> getAutores() {
		return autores;
	}

	public List<Integer> getSelectedAutoresIds() {
		return selectedAutoresIds;
	}

	public void setSelectedAutoresIds(List<Integer> selectedAutoresIds) {
		this.selectedAutoresIds = selectedAutoresIds;
	}

	@Transactional
	public String save() {
		popularLivroAutor();
		livroDAO.save(produto);
		messagesHelper.addFlash(new FacesMessage("Livro gravado com sucesso"));
		return "/admin/livros/list?faces-redirect=true";
	}

	private void popularLivroAutor() {
		selectedAutoresIds.stream().map((id) -> {
			return new Autor(id);
		}).forEach(produto::add);
	}

}
