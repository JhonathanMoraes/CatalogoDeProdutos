
package com.atividadem2.catalogodeprodutos.repositories;

import com.atividadem2.catalogodeprodutos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
