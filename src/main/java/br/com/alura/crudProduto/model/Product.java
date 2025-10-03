package br.com.alura.crudProduto.model;

import br.com.alura.crudProduto.dto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product(DadosCadastroProduto dadosCadastroProduto) {
        this.name =  dadosCadastroProduto.nome();
        this.description = dadosCadastroProduto.descricao();
        this.price = dadosCadastroProduto.preco();
        this.stock = dadosCadastroProduto.quantidade();
    }
}
