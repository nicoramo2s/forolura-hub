package ff.api.forohub.domain.topico.respuesta.validaciones;

import ff.api.forohub.domain.topico.TopicoRepository;
import ff.api.forohub.domain.topico.respuesta.DatosCrearRespuesta;
import ff.api.forohub.domain.topico.respuesta.RespuestaRepository;
import ff.api.forohub.domain.usuario.UsuarioRepository;
import ff.api.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaValida implements ValidadorRespuesta {

    private final RespuestaRepository respuestaRepository;

    private final UsuarioRepository usuarioRepository;

    private final TopicoRepository topicoRepository;

    public RespuestaValida(RespuestaRepository respuestaRepository, UsuarioRepository usuarioRepository, TopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.mensaje() == null) {
            throw new ValidacionDeIntegridad("mensaje no encontrado");
        }

        if (respuestaRepository.existsByTopicoAndMensajeAndAutorRespuesta(
                topicoRepository.getReferenceById(datos.idTopico()),
                datos.mensaje(),
                usuarioRepository.getReferenceById(datos.idAutor()))) {
            throw new ValidationException("Ya existe una respuesta igual para el topico");
        }
    }
}
