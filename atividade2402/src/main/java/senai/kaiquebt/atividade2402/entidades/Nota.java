package senai.kaiquebt.atividade2402.entidades;

public class Nota {
	private Integer id;
	private Aluno aluno;
	private Sala sala;
	private double nota = 0.0;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		if (nota > 10) {
			nota = 10;
		}
		if (nota < 0) {
			nota = 0;
		}
		this.nota = nota;
	}
}
