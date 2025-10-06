package br.com.alura.crudProduto.service;

import br.com.alura.crudProduto.ProductRepository;
import br.com.alura.crudProduto.dto.DadosAtualizarProduto;
import br.com.alura.crudProduto.dto.DadosCadastroProduto;
import br.com.alura.crudProduto.dto.DadosDetalhamentoProduto;
import br.com.alura.crudProduto.dto.DadosListagemProduto;
import br.com.alura.crudProduto.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity createProduct(DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriBuilder) {
        var product = new Product(dadosCadastroProduto);
        productRepository.save(product);

        var uri = uriBuilder.path("produto/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(product));
    }

    public ResponseEntity<Page<DadosListagemProduto>> getallProduct(Pageable pageable) {
        var page = productRepository.findAll(pageable).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity deleteproduct(Long id) {
     var product = productRepository.getReferenceById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity getProduct(Long id) {
        var product = productRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(product));
    }

    public ResponseEntity updateproduct(DadosAtualizarProduto dadosAtualizarProduto) {
        var product = productRepository.getReferenceById(dadosAtualizarProduto.id());
        product.atualizar(dadosAtualizarProduto);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(product));
    }
}
