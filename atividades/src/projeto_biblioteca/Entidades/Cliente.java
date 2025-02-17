package projeto_biblioteca.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private static long counter = 0 ;
	long id = 0;
	String nome;
	String cpf;
	String endereco;
	String telefone;
	List<Livro> livrosEmprestados = new ArrayList<>();
	
	public List<Livro> getLivrosEmprestados() {
		return livrosEmprestados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Cliente(String username, String password, String nome, String cpf, String endereco, String telefone) {
		super(username, password);
		this.id = counter ++;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	
	
}
