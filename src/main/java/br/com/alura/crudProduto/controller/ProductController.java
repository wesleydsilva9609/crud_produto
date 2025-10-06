package br.com.alura.crudProduto.controller;

import br.com.alura.crudProduto.dto.DadosCadastroProduto;
import br.com.alura.crudProduto.dto.DadosListagemProduto;
import br.com.alura.crudProduto.service.ProductService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProductService service;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriBuilder) {
        return service.createProduct(dadosCadastroProduto,uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProduto>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        return service.getallProduct(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return service.deleteproduct(id);
    }

}
