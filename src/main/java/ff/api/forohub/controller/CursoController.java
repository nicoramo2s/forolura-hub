package ff.api.forohub.controller;

import ff.api.forohub.domain.curso.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearCurso(@RequestBody @Valid DatosCrearCurso datos) {
        var response = service.crearCurso(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datos) {
        var response = service.actualizarCurso(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstadoCurso(@PathVariable Long id){
        service.cambiarEstado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activos")
    public ResponseEntity<Page<DatosCurso>> listarCursosActivos(@PageableDefault(size=10) Pageable paginacion) {
        var response = service.listarCursosActivos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Page<DatosCurso>> listarCursosInactivos(@PageableDefault(size=10) Pageable paginacion) {
        var response = service.listarCursosInactivos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosCurso>> listarCursos(@PageableDefault(size = 10) Pageable paginacion) {
        var response = service.listarCursos(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarCurso(@PageableDefault(size = 10)Pageable paginacion,
                                       @PathVariable @Valid Long id) {
        var response = service.mostrarCurso(id, paginacion);
        return ResponseEntity.ok(response);
    }
}
