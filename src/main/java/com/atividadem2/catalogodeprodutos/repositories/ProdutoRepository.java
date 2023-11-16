
package com.atividadem2.catalogodeprodutos.repositories;

import com.atividadem2.catalogodeprodutos.models.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @Query(value = "SELECT * FROM produto WHERE usuario_id = ?1", nativeQuery = true)
    List<Produto> findByIdUsuario(Long id);
}
