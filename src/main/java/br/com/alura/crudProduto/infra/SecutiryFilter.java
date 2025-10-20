package br.com.alura.crudProduto.infra;

import br.com.alura.crudProduto.UserRepository;
import br.com.alura.crudProduto.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecutiryFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = recuperarToken(request);
        System.out.println("chamando filtro");

        if (token != null) {
            var subject = tokenService.VerifyToken(token);
            var user = userRepository.findByUsername(subject);
            var authentication = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }



    private String recuperarToken(HttpServletRequest request) {
        var authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer ")){
            return authorization.replace("Bearer ", "").trim();
        }
        return null;
    }
}
