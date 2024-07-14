package ff.api.forohub.domain.topico;

import ff.api.forohub.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Boolean existsByTituloAndMensaje(String tituloTopico, String mensajeTopico);

    void removeById(Long id);

    Page<Topico> findAllByCurso(Curso curso, Pageable paginacion);

    Page<Topico> findAllByStatusTrue(Pageable paginacion);

    Page<Topico> findAllByStatusFalse(Pageable paginacion);
}
