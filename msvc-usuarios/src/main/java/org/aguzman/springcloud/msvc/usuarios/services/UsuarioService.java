package org.aguzman.springcloud.msvc.usuarios.services;

import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Long id);
    boolean existByEmail(String email);
}
