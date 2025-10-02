package br.com.alura.crudProduto.controller;

import br.com.alura.crudProduto.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService adminService;

    @PostMapping()
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUser dadosCadastroUser, UriComponentsBuilder uriBuilder) {
        return adminService.cadastrar(dadosCadastroUser,uriBuilder);
    }

}
