package senai.kaiquebt.contatos.controlador;

import senai.kaiquebt.contatos.entidades.Contato;
import senai.kaiquebt.contatos.servico.ContatoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/contatos")
@Tag(name = "Controlador de Contatos", description = "Operações CRUD para a entidade Contato")
public class ContatoControlador {

    private final ContatoServico contatoServico;

    @Autowired
    public ContatoControlador(ContatoServico contatoServico) {
        this.contatoServico = contatoServico;
    }

    @GetMapping
    @Operation(summary = "Buscar todos os contatos", description = "Retorna uma lista de todos os contatos")
    @ApiResponse(responseCode = "200", description = "Contatos recuperados com sucesso")
    public ResponseEntity<List<Contato>> buscarTodosContatos() {
        List<Contato> contatos = contatoServico.buscarTodosContatos();
        contatos.forEach(contato -> {
            contato.getGrupos().forEach(grupo -> grupo.setContatos(null));
        });
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contato por ID", description = "Retorna um único contato por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato recuperado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<Contato> buscarContatoPorId(
            @Parameter(description = "ID do contato a ser recuperado") @PathVariable Long id) {
        Optional<Contato> contato = contatoServico.buscarContatoPorId(id);
        if (contato.isPresent()) {
            contato.get().setGrupos(null);
        }
        return contato.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @Operation(summary = "Criar um novo contato", description = "Cria um novo contato e o retorna")
    @ApiResponse(responseCode = "201", description = "Contato criado com sucesso")
    public ResponseEntity<Contato> criarContato(
            @Parameter(description = "Contato a ser criado") @Valid @RequestBody Contato contato) {
        Contato contatoSalvo = contatoServico.salvarContato(contato);
        return new ResponseEntity<>(contatoSalvo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um contato", description = "Atualiza um contato existente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<Contato> atualizarContato(
            @Parameter(description = "ID do contato a ser atualizado") @PathVariable Long id,
            @Parameter(description = "Detalhes atualizados do contato") @Valid @RequestBody Contato contato) {
        try {
            Contato contatoAtualizado = contatoServico.atualizarContato(id, contato);
            return new ResponseEntity<>(contatoAtualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{contatoId}/grupo/{grupoId}")
    @Operation(summary = "Adicionar contato a um grupo", description = "Adiciona um contato a um grupo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato adicionado ao grupo com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato ou grupo não encontrado")
    })
    public ResponseEntity<Void> adicionarContatoAGrupo(
            @Parameter(description = "ID do contato a ser adicionado") @PathVariable Long contatoId,
            @Parameter(description = "ID do grupo ao qual o contato será adicionado") @PathVariable Long grupoId) {
        try {
            contatoServico.adicionarContatoAGrupo(contatoId, grupoId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{contatoId}/grupo/{grupoId}")
    @Operation(summary = "Remover contato a um grupo", description = "Remove um contato a um grupo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato removido ao grupo com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato ou grupo não encontrado")
    })
    public ResponseEntity<Void> removerContatoAGrupo(
            @Parameter(description = "ID do contato a ser removido") @PathVariable Long contatoId,
            @Parameter(description = "ID do grupo ao qual o contato será removido") @PathVariable Long grupoId) {
        try {
            contatoServico.removerContatoAGrupo(contatoId, grupoId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um contato", description = "Exclui um contato por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Contato excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<Void> excluirContato(
            @Parameter(description = "ID do contato a ser excluído") @PathVariable Long id) {
        Optional<Contato> contato = contatoServico.buscarContatoPorId(id);
        if (contato.isPresent()) {
            contatoServico.excluirContato(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

