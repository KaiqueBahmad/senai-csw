package senai.kaiquebt.atividade2402.dto;

import senai.kaiquebt.atividade2402.entidades.Aluno;
import senai.kaiquebt.atividade2402.entidades.Sala;

public class SalaResponse {
	private Integer id;
	private AlunoResponse[] alunos;
	
	public SalaResponse(Sala sala) {
		this.id = sala.getId();
		this.alunos = new AlunoResponse[sala.getAlunos().size()];
		int i = 0;
		for (Aluno aluno_ : sala.getAlunos()) {
			AlunoResponse alunoResponse = new AlunoResponse();
			alunoResponse.setId(aluno_.getId());
			alunoResponse.setNome(aluno_.getNome());
			alunoResponse.setMatricula(aluno_.getMatricula());
			alunos[i++] = alunoResponse;
		}
	}
	
	public AlunoResponse[] getAlunos() {
		return alunos;
	}
	public void setAlunos(AlunoResponse[] alunos) {
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
