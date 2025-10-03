package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.User;

public record DadosDetalhamentoUsuario(String username, String role) {

    public DadosDetalhamentoUsuario(User user) {
        this(user.getUsername(), user.getRole());
    }
}
