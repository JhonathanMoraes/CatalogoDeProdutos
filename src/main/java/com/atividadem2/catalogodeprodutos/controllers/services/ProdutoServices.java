
package com.atividadem2.catalogodeprodutos.controllers.services;

import com.atividadem2.catalogodeprodutos.models.Produto;
import com.atividadem2.catalogodeprodutos.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServices {
    
    @Autowired
    ProdutoRepository repository;
    
    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Produto produto, Long id) {
        try {
            Produto entity = repository.getReferenceById(id);
            atualizarDados(entity, produto);
            return repository.save(entity);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException(ex.getMessage());
        }
    }

    public void atualizarDados(Produto entity, Produto produto) {
        entity.setUsuarioId(produto.getUsuarioId());
        entity.setDescricao(produto.getDescricao());
        entity.setPreco(produto.getPreco());
        entity.setQuantidade(produto.getQuantidade());
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

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorIdProduto(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.get();
    }

    public List<Produto> buscarPorIdUsuario(Long id) {
        return repository.findByIdUsuario(id);
    }
}
