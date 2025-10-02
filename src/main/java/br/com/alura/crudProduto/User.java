package br.com.alura.crudProduto;

import br.com.alura.crudProduto.controller.DadosCadastroUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    public User(DadosCadastroUser dadosCadastroUser) {
        this.username = dadosCadastroUser.username();
        this.password = dadosCadastroUser.senha();
        this.role = dadosCadastroUser.role();
    }
}
