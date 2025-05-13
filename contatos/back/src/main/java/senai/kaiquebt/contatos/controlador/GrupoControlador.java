package senai.kaiquebt.contatos.controlador;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import senai.kaiquebt.contatos.entidades.Grupo;
import senai.kaiquebt.contatos.servico.GrupoServico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/grupos")
public class GrupoControlador {
    @Autowired
    private GrupoServico grupoServico;

    @GetMapping("")
    public ResponseEntity<List<Grupo>> buscarTodosGrupos() {
        List<Grupo> grupos = grupoServico.buscarTodosGrupos();
        return new ResponseEntity<>(grupos, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Grupo> criarGrupo(@RequestBody Grupo grupo) {
        System.out.println(grupo);
        System.out.println(grupo.getNome());
        Grupo grupoSalvo = grupoServico.criarGrupo(grupo.getNome());
        return new ResponseEntity<>(grupoSalvo, HttpStatus.CREATED);
    }

}
