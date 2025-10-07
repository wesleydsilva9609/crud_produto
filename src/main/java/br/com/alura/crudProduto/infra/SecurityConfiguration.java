package br.com.alura.crudProduto.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private SecutiryFilter secutiryFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(ssm -> ssm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(rqs ->
                        rqs.requestMatchers("/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/login/cadastro").permitAll()
                                .requestMatchers(HttpMethod.POST, "/produto").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/produto").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/produto").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/produto").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.GET, "/produto/{id}").hasAnyRole("ADMIN", "USER")
                                .anyRequest().authenticated())
                .addFilterBefore(secutiryFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
       return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
