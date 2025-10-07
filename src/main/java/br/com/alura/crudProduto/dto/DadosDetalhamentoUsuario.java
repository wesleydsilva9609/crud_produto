package br.com.alura.crudProduto.dto;

import br.com.alura.crudProduto.model.Usuario;

public record DadosDetalhamentoUsuario(String username, String role) {

    public DadosDetalhamentoUsuario(Usuario user) {
        this(user.getUsername(), user.getRole());
    }
}
