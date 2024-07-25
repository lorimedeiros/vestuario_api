package com.vestuario.lori.projsb.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desabilita CSRF para facilitar testes com Insomnia
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define stateless
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/vestuario/**").permitAll() // Permite acesso a endpoints vestuario sem autenticação
                        .anyRequest().authenticated() // Requer autenticação para todas as outras requisições
                );
        return http.build();
    }
}
