package senai.kaiquebt.contatos.repositorio;

import senai.kaiquebt.contatos.entidades.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepositorio  extends JpaRepository<Grupo, Long> {
}
