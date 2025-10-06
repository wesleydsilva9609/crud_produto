package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Product;

public record DadosListagemProduto(Long id,String name, String description, Double price, int stock) {

    public DadosListagemProduto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

}
