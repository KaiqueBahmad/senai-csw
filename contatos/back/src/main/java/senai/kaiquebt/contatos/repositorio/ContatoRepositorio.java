package senai.kaiquebt.contatos.repositorio;

import senai.kaiquebt.contatos.entidades.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long> {
}

