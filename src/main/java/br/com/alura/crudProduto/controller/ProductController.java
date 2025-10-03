package br.com.alura.crudProduto.controller;

import br.com.alura.crudProduto.dto.DadosCadastroProduto;
import br.com.alura.crudProduto.model.Product;
import br.com.alura.crudProduto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity create(@RequestBody DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriBuilder) {
        return service.createProduct(dadosCadastroProduto,uriBuilder);
    }

}
