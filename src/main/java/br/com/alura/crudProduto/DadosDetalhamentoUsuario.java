package br.com.alura.crudProduto;

public record DadosDetalhamentoUsuario(String username, String role) {

    public DadosDetalhamentoUsuario(User user) {
        this(user.getUsername(), user.getRole());
    }
}
