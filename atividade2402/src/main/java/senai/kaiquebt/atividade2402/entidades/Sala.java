package senai.kaiquebt.atividade2402.entidades;
import java.util.LinkedList;
import java.util.List;

public class Sala {
	private Integer id;
	private String nome;
	private List<Aluno> alunos = new LinkedList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", nome=" + nome + ", alunos=" + alunos + "]";
	}
	
}
