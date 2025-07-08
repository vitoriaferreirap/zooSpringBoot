package com.vitoriaferreiradev.zoo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para permitir POST/PUT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/animais/**").authenticated() // Requer autenticação para /animais
                        .anyRequest().authenticated())
                .httpBasic(); // Habilita autenticação básica

        return http.build();
    }
}
