package br.com.alura.crudProduto.dto;

import jakarta.validation.constraints.NotBlank;

public record Dadoslogin(@NotBlank String email,@NotBlank String senha) {
}
