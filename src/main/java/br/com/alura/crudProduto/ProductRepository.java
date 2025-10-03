package br.com.alura.crudProduto;

import br.com.alura.crudProduto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
