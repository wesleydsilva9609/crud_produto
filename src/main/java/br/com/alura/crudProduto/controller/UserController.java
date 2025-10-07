package br.com.alura.crudProduto.controller;

import br.com.alura.crudProduto.dto.Dadoslogin;
import br.com.alura.crudProduto.service.UserService;
import br.com.alura.crudProduto.dto.DadosCadastroUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUser dadosCadastroUser, UriComponentsBuilder uriBuilder) {
        return userService.cadastrar(dadosCadastroUser,uriBuilder);
    }

    @PostMapping
    @Transactional
    public ResponseEntity Login(@RequestBody Dadoslogin dadoslogin) {
        return userService.logar(dadoslogin);
    }

}
