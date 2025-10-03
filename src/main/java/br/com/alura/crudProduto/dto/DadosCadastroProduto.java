package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Product;

public record DadosCadastroProduto(String nome, String descricao, double preco, int quantidade) {

    public DadosCadastroProduto(Product product) {
        this(product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}
