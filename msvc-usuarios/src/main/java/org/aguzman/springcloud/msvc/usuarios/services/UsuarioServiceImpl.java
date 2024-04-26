package org.aguzman.springcloud.msvc.usuarios.services;

import org.aguzman.springcloud.msvc.usuarios.models.entity.Usuario;
import org.aguzman.springcloud.msvc.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
