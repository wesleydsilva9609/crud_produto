package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Product;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarProduto(@NotBlank Long id, String nome, String descricao, double preco, int quantidade) {

    public DadosAtualizarProduto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}
