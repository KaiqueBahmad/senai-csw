package senai.kaiquebt.contatos.servico;

import senai.kaiquebt.contatos.entidades.Contato;
import senai.kaiquebt.contatos.entidades.Grupo;
import senai.kaiquebt.contatos.repositorio.ContatoRepositorio;
import senai.kaiquebt.contatos.repositorio.GrupoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServico {

    private final ContatoRepositorio contatoRepositorio;
    private final GrupoRepositorio grupoRepositorio;
    @Autowired
    public ContatoServico(ContatoRepositorio contatoRepositorio, GrupoRepositorio grupoRepositorio) {
        this.grupoRepositorio = grupoRepositorio;
        this.contatoRepositorio = contatoRepositorio;
    }

    public List<Contato> buscarTodosContatos() {
        return contatoRepositorio.findAll();
    }

    public Optional<Contato> buscarContatoPorId(Long id) {
        return contatoRepositorio.findById(id);
    }

    public Contato salvarContato(Contato contato) {
        return contatoRepositorio.save(contato);
    }

    public Contato adicionarContatoAGrupo(Long idContato, Long idGrupo) {
        Contato contato = contatoRepositorio.findById(idContato)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o id: " + idContato));
        Grupo grupo = grupoRepositorio.findById(idGrupo)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com o id: " + idGrupo));
        grupo.getContatos().add(contato);
        contato.getGrupos().add(grupo);
        grupoRepositorio.save(grupo);
        return contatoRepositorio.save(contato);
    }

    public void removerContatoAGrupo(Long contatoId, Long grupoId) {
        Contato contato = contatoRepositorio.findById(contatoId)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o id: " + contatoId)); 
        Grupo grupo = grupoRepositorio.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com o id: " + grupoId));
        grupo.getContatos().remove(contato);
        contato.getGrupos().remove(grupo);
        contatoRepositorio.save(contato);
        grupoRepositorio.save(grupo);
    }

    public Contato toggleFavoritar(Contato contato) {
        contato.setFavorito(contato.getFavorito() == null ? true: !contato.getFavorito());
        return this.contatoRepositorio.save(contato);
    }

    public void excluirContato(Long id) {
        contatoRepositorio.deleteById(id);
    }

    public Contato atualizarContato(Long id, Contato detalhesContato) {
        Contato contato = contatoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o id: " + id));

        contato.setNome(detalhesContato.getNome());
        contato.setEmail(detalhesContato.getEmail());
        contato.setTelefone(detalhesContato.getTelefone());

        return contatoRepositorio.save(contato);
    }
}


