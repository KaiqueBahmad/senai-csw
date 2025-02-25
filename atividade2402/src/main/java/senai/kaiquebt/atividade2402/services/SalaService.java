package senai.kaiquebt.atividade2402.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import senai.kaiquebt.atividade2402.entidades.Aluno;
import senai.kaiquebt.atividade2402.entidades.Nota;
import senai.kaiquebt.atividade2402.entidades.Sala;

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
		aluno.setMatricula(UUID.randomUUID().toString());
		aluno.setId(ALUNO_COUNTER);
		return aluno;
	}

	public Sala criarSala(Sala sala) {
		if (sala.getNome() == null) {
			throw new RuntimeErrorException(null, "Nome não pode ser nulo");
		}
		sala.setAlunos(new LinkedList<>());
		for (Sala salaExistente: this.salas.values()) {
			if (salaExistente.getNome().equalsIgnoreCase(sala.getNome())) {
				throw new RuntimeErrorException(null, "Já existe uma sala com o nome: "+sala.getNome());
			}
		}
	    SALA_COUNTER++;
	    salas.put(SALA_COUNTER, sala);
	    sala.setId(SALA_COUNTER);
	    return sala;
	}
	
	public Nota criarNota(Nota nota) {
		System.out.println(nota.getSala().getId());
		System.out.println(salas.get(nota.getSala().getId()));
		if (nota.getSala() == null ||!salas.containsKey(nota.getSala().getId())) {
			throw new RuntimeErrorException(null, "Sala não encontrada.");
		}
		if (nota.getAluno() == null || !alunos.containsKey(nota.getAluno().getId())) {
			throw new RuntimeErrorException(null, "Aluno não encontrado");
		}
		
		nota.setAluno(this.alunos.get(nota.getAluno().getId()));
		nota.setSala(this.salas.get(nota.getSala().getId()));
		
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

	public Sala addAlunoNaSala(Integer salaId, Integer alunoId) {
		Sala sala = salas.get(salaId);
		Aluno aluno = alunos.get(alunoId);
		sala.getAlunos().add(aluno);
		aluno.setSala(sala);
		return sala;
	}

	public Sala buscarSala(Integer salaId) {
		if (!salas.containsKey(salaId)) {
			throw new RuntimeErrorException(null, "Sala não encontrada.");
		}
		return this.salas.get(salaId);
	}

	public Double getMedia(Integer salaId, Integer alunoId) {
		double media = 0;
		SalaAluno chave = new SalaAluno(salaId, alunoId);
		if (!notas.containsKey(chave)) {
			throw new RuntimeErrorException(null, "Aluno não encontrado nesta sala");
		}
		for (Nota nota: notas.get(chave)) {
			media += nota.getNota();
		}
		if (media == 0) {
			return 0.0;
		}
		return media / notas.get(chave).size();
	}
	
}
