// package com.example.estoque.security;

// import static org.springframework.security.config.Customizer.withDefaults;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfiguration {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(authorize -> authorize
//                         .requestMatchers("api/**").permitAll()
//                         .anyRequest().authenticated())
//                 .httpBasic(withDefaults());// Configuração HTTP Básico

//         return http.build();
//     }

// }
