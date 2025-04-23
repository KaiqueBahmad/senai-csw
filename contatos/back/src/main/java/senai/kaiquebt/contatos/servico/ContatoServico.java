package senai.kaiquebt.contatos.servico;

import senai.kaiquebt.contatos.entidades.Contato;
import senai.kaiquebt.contatos.repositorio.ContatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServico {

    private final ContatoRepositorio contatoRepositorio;

    @Autowired
    public ContatoServico(ContatoRepositorio contatoRepositorio) {
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


