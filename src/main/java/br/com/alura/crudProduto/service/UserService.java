package br.com.alura.crudProduto.service;


import br.com.alura.crudProduto.UserRepository;
import br.com.alura.crudProduto.dto.DadosCadastroUser;
import br.com.alura.crudProduto.dto.DadosDetalhamentoUsuario;
import br.com.alura.crudProduto.dto.DadosJWT;
import br.com.alura.crudProduto.dto.Dadoslogin;
import br.com.alura.crudProduto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;


    public ResponseEntity cadastrar(DadosCadastroUser dadosCadastroUser, UriComponentsBuilder uriBuilder) {
        var Cryptpassword = passwordEncoder.encode(dadosCadastroUser.senha());
        var user = new Usuario(dadosCadastroUser.username(), Cryptpassword, dadosCadastroUser.role());
        userRepository.save(user);
        var uri = uriBuilder.path("/admin").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(user));
    }


    public ResponseEntity logar(Dadoslogin dadoslogin) {
        var token = new UsernamePasswordAuthenticationToken(dadoslogin.email(), dadoslogin.senha());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJWT(tokenJWT));
    }
}
