package senai.kaiquebt.contatos.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.kaiquebt.contatos.entidades.Grupo;
import senai.kaiquebt.contatos.repositorio.GrupoRepositorio;

@Service
public class GrupoServico {

    @Autowired
    private GrupoRepositorio grupoRepositorio;

    public Grupo criarGrupo(String nome) {
        System.out.println(nome);
        Grupo grupo = new Grupo();
        grupo.setNome(nome);
        return this.grupoRepositorio.save(grupo);
    }

    public List<Grupo> buscarTodosGrupos() {
        return this.grupoRepositorio.findAll();
    }
}
