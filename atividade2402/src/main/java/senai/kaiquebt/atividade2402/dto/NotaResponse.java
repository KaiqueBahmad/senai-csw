package senai.kaiquebt.atividade2402.dto;

import senai.kaiquebt.atividade2402.entidades.Nota;

public class NotaResponse {
	private Double nota;
	private String aluno;
	private String sala;
	
	public NotaResponse(Nota nota) {
		this.nota = nota.getNota();
		this.aluno = nota.getAluno().getNome();
		this.sala = nota.getSala().getNome();
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
}
