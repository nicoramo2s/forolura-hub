package ff.api.forohub.domain.curso.validaciones;

import ff.api.forohub.domain.curso.Categoria;
import ff.api.forohub.domain.curso.DatosCrearCurso;
import ff.api.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValida implements ValidadorCurso{

    @Override
    public void validar(DatosCrearCurso datos) {
        if (datos.categoria() == null) {
            throw new ValidacionDeIntegridad("Debe asignarle una categoria al curso");
        }
        //Validar Enum

    }
}
