package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Product;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(@NotBlank String nome,@NotBlank String descricao,@NotBlank double preco,@NotBlank int quantidade) {

    public DadosCadastroProduto(Product product) {
        this(product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}
