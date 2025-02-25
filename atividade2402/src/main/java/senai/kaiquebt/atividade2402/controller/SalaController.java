package senai.kaiquebt.atividade2402.controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import senai.kaiquebt.atividade2402.dto.AlunoResponse;
import senai.kaiquebt.atividade2402.dto.MediaResponse;
import senai.kaiquebt.atividade2402.dto.NotaResponse;
import senai.kaiquebt.atividade2402.dto.SalaResponse;
import senai.kaiquebt.atividade2402.entidades.Aluno;
import senai.kaiquebt.atividade2402.entidades.Nota;
import senai.kaiquebt.atividade2402.entidades.Sala;
import senai.kaiquebt.atividade2402.services.SalaService;

@RestController
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("sala/{salaId}")
	public ResponseEntity<?> getSala(@PathVariable Integer salaId) {
		return ResponseEntity.ok(new SalaResponse(salaService.buscarSala(salaId)));
	}
	
	@PostMapping("nota")
	public ResponseEntity<?> novaNota(@RequestBody Nota nota) {
		System.out.println(nota);
		try {
			return ResponseEntity.ok(new NotaResponse(this.salaService.criarNota(nota)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("sala/{salaId}/aluno/{alunoId}/medias")
	public ResponseEntity<?> getMedias(@PathVariable Integer salaId, @PathVariable Integer alunoId) {
		try {
			return ResponseEntity.ok(this.salaService.getMedia(salaId, alunoId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
		
	@PostMapping("sala")
	public ResponseEntity<?> criarSala(@RequestBody Sala sala) {
		try {
			return ResponseEntity.ok(salaService.criarSala(sala));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("aluno")
	public ResponseEntity<?> criarAluno(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.ok(salaService.criarAluno(aluno));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("sala/{salaId}/add/{alunoId}")
	public ResponseEntity<?> addAlunoNaSala(@PathVariable Integer salaId, @PathVariable Integer alunoId) {
		try {
			return ResponseEntity.ok(new SalaResponse(salaService.addAlunoNaSala(salaId, alunoId)));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
