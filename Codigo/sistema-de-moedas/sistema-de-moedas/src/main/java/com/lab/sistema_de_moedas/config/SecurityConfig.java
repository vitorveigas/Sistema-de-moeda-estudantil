package com.lab.sistema_de_moedas.config;

import com.lab.sistema_de_moedas.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/alunos/criarAluno").permitAll()
                .requestMatchers("/alunos/perfil").permitAll()
                .requestMatchers("/alunos/buscarPorMatricula").permitAll()
                .requestMatchers("/professores/criarProfessor").permitAll()
                .requestMatchers("/professores/perfil").permitAll()
                .requestMatchers("/empresas/criar").permitAll()
                // Endpoints de transações
                .requestMatchers("/transacoes/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/transacoes/aluno/**").permitAll()
                .requestMatchers("/vantagens/**").permitAll()
                .requestMatchers("/vantagens/listar").permitAll()
                .requestMatchers("/vantagens/criar-com-imagem").permitAll()
                .requestMatchers("/vantagens/criar-com-url").permitAll()

                .requestMatchers("/alunos/historico").permitAll()
                // Tudo o resto exige autenticação
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // 🔹 Permite suas origens de front-end
        configuration.setAllowedOrigins(List.of(
                "http://localhost:5500",
                "http://127.0.0.1:5500"
        ));
        
        // 🔹 Métodos HTTP liberados, incluindo OPTIONS para preflight
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // 🔹 Permite todos os headers, incluindo Authorization
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));
        
        // 🔹 Permite cookies se necessário
        configuration.setAllowCredentials(true);

        // 🔹 Configura URLs
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
    

}
