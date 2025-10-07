package br.com.alura.crudProduto;

import br.com.alura.crudProduto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByUsername(String username);
}
