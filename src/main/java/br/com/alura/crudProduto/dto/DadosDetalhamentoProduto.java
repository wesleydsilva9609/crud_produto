package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Product;

public record DadosDetalhamentoProduto(String name, String description, double price,  int stock) {

    public DadosDetalhamentoProduto(Product product) {
        this(product.getName(), product.getDescription(), product.getPrice(),  product.getStock());
    }
}
