package senai.kaiquebt.atividade2402.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import senai.kaiquebt.atividade2402.entidades.Sala;

@RestController
public class SalaController {
	
	@PostMapping("sala")
	public ResponseEntity<?> criarSala(@RequestBody Sala sala) {
		
		
		return ResponseEntity.ok("Teste");
	}
	
}
