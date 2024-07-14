package ff.api.forohub.domain.curso;

import ff.api.forohub.domain.curso.validaciones.ValidadorCurso;
import ff.api.forohub.domain.topico.DatosTopico;
import ff.api.forohub.domain.topico.TopicoRepository;
import ff.api.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorCurso> validadorCursos;

    public DatosCurso crearCurso(DatosCrearCurso datos) {
        validadorCursos.forEach(v -> v.validar(datos));
        var curso = new Curso(datos.nombre(), datos.categoria());
        cursoRepository.save(curso);
        return new DatosCurso(curso);
    }

    public DatosCurso actualizarCurso(DatosActualizarCurso datos) {
        cursoExistente(datos.id());
        var curso = cursoRepository.getReferenceById(datos.id());
        curso.actualizar(datos);
        return new DatosCurso(curso);
    }

    public DatosCurso cambiarEstado(Long id) {
        cursoExistente(id);
        var curso = cursoRepository.getReferenceById(id);
        curso.setActivo();
        return new DatosCurso(curso);
    }

    private void cursoExistente(Long id) {
        if (id == null) {
            throw new ValidationException("Deve proporcionar el id del curso");
        }

        if (!cursoRepository.existsById(id)) {
            throw new ValidacionDeIntegridad("Debe proporcionar el ID de curso valido");
        }
    }

    public Page<DatosCurso> listarCursosActivos(Pageable paginacion) {
        return cursoRepository.findByActivoTrue(paginacion).map(DatosCurso::new);
    }

    public Page<DatosCurso> listarCursosInactivos(Pageable paginacion) {
        return cursoRepository.findByActivoFalse(paginacion).map(DatosCurso::new);
    }

    public Page<DatosCurso> listarCursos(Pageable paginacion) {
        return cursoRepository.findAll(paginacion).map(DatosCurso::new);
    }

    public DatosCursoTopicos mostrarCurso(Long id, Pageable paginacion) {
        cursoExistente(id);
        var curso = cursoRepository.getReferenceById(id);
        var topicos = topicoRepository.findAllByCurso(curso, paginacion).map(DatosTopico::new);
        return new DatosCursoTopicos(new DatosCurso(curso), topicos);
    }
}
