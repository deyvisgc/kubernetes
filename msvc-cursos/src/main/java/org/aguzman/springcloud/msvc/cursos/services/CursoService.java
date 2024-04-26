package org.aguzman.springcloud.msvc.cursos.services;

import org.aguzman.springcloud.msvc.cursos.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void delete(Long id);
}
