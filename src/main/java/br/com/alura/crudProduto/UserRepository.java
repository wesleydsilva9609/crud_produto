package br.com.alura.crudProduto;

import br.com.alura.crudProduto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
