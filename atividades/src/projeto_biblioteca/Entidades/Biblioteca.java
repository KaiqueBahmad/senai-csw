package projeto_biblioteca.Entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
	List<Usuario> usuarios = new ArrayList<>();
	Map<Long, Livro> livros = new HashMap<>();
	String nome;
	
	public Biblioteca(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public boolean jaCadastrado(Livro livro) {
		for (Livro livroNoEstoque: livros.values()) { 
			if (livroNoEstoque.equals(livro)) {// Na Classe Livro eu implementei um equals
				return true;
			}
		}
		return false;
	}

	public Map<Long, Livro> getLivros() {
		return livros;
	}

	public void mostrarLivros() {
		for (Livro livro: livros.values()) {
			System.out.println(livro);
		}
	}
	
	
	
	
}
