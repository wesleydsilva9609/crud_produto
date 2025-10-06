package br.com.alura.crudProduto.service;


import br.com.alura.crudProduto.UserRepository;
import br.com.alura.crudProduto.dto.DadosCadastroUser;
import br.com.alura.crudProduto.dto.DadosDetalhamentoUsuario;
import br.com.alura.crudProduto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity cadastrar(DadosCadastroUser dadosCadastroUser, UriComponentsBuilder uriBuilder) {
        var user = new User(dadosCadastroUser);
        userRepository.save(user);
        var uri = uriBuilder.path("/admin").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(user));
    }


}
