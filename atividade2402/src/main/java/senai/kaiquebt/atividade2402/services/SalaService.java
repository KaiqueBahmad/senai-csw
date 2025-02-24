package services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import entidades.Aluno;
import entidades.Nota;
import entidades.Sala;


@Service
public class SalaService {
	private static int ALUNO_COUNTER = 0;
	private Map<Integer, Aluno> alunos = new HashMap<>();

	private static int SALA_COUNTER = 0;
	private Map<Integer, Sala> salas = new HashMap<>();

	private static int NOTA_COUNTER = 0;
	record SalaAluno(Integer salaId, Integer alunoId) {}
	private Map<SalaAluno, List<Nota>> notas = new HashMap<>();
	
	
	private static int MAX_NOTAS_PER_ALUNO_PER_SALA = 3;
	
	public List<Aluno> listarAlunos() {
		return (List<Aluno>) alunos.values();
	}
	
	public List<Aluno> listarAlunos(int salaId){
		if (!salas.containsKey(salaId)) {
			return null;
		}
		return (List<Aluno>) salas.get(salaId).getAlunos();
	}
	public List<Aluno> listarAlunos(Sala sala) {
		return this.listarAlunos(sala.getId());
	}
	
	public Aluno criarAluno(Aluno aluno) {
		ALUNO_COUNTER++;
		alunos.put(ALUNO_COUNTER, aluno);
		aluno.setId(ALUNO_COUNTER);
		return aluno;
	}

	public Sala criarSala(Sala sala) {
	    SALA_COUNTER++;
	    salas.put(SALA_COUNTER, sala);
	    sala.setId(SALA_COUNTER);
	    return sala;
	}
	
	public Nota criarNota(Nota nota) {
		if (nota.getAluno() == null) {
			return null;
		}
		if (nota.getSala() == null) {
			return null;
		}
		if (nota.getAluno().getId() == null) {
			nota.setAluno(criarAluno(nota.getAluno()));
		}
		
		if (nota.getSala().getId() == null) {
			nota.setSala(criarSala(nota.getSala()));
		}
		
		SalaAluno chave = new SalaAluno(nota.getSala().getId(), nota.getAluno().getId());
		if (!notas.containsKey(chave)) {
			notas.put(chave, new LinkedList<Nota>());
		}
		if (notas.get(chave).size() >= MAX_NOTAS_PER_ALUNO_PER_SALA) {
			return null;
		}
		NOTA_COUNTER++;
		nota.setId(NOTA_COUNTER);
		notas.get(chave).add(nota);
		return nota;
	}
	
	
}
