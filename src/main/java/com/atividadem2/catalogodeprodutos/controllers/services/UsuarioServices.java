
package com.atividadem2.catalogodeprodutos.controllers.services;

import com.atividadem2.catalogodeprodutos.models.Usuario;
import com.atividadem2.catalogodeprodutos.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    
    @Autowired
    UsuarioRepository repository;
    
     public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        try {
            Usuario entity = repository.getReferenceById(id);
            atualizarDados(entity, usuario);
            return repository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException(ex.getMessage());
        }
    }

    public void atualizarDados(Usuario entity, Usuario usuario) {
        entity.setNome(usuario.getNome());
        entity.setTipoUsuario(usuario.getTipoUsuario());
        
    }
    
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException(ex.getMessage(), ex.getExpectedSize());
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException(ex.getMessage());
        }
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.get();
    }
}
