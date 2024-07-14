package ff.api.forohub.domain.curso;

public record DatosCurso(Long id, String nombre, Categoria categoria, Boolean activo) {

    public DatosCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.getActivo());
    }
}
