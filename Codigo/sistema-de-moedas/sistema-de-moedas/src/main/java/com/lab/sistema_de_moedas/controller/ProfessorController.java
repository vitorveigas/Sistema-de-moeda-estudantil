package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.service.JwtService;
import com.lab.sistema_de_moedas.service.ProfessorServices; // Ensure you have a ProfessorServices class
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorServices professorServices; // Serviço responsável pelas operações relacionadas ao Professor

    @Autowired
    private JwtService jwtService; // Serviço responsável por manipular tokens JWT
    private final PasswordEncoder passwordEncoder; // Encoder para senhas

    @PostMapping("criarProfessor")
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        // Extraímos a lógica de validação e codificação da senha para um método separado
        validateAndEncodePassword(professor);
        professorServices.criarProfessor(professor); // Chamamos o serviço para criar o professor
        return ResponseEntity.ok(professor); // Retornamos o professor criado
    }

    @GetMapping("/perfil")
    public ResponseEntity<Professor> perfil(@RequestHeader("Authorization") String authHeader) {
        try {
            // Extraímos a lógica de extração do e-mail do cabeçalho de autorização para um método separado
            String email = extractEmailFromAuthHeader(authHeader);
            Professor professor = professorServices.findByEmail(email); // Buscamos o professor pelo e-mail
            return ResponseEntity.ok(professor); // Retornamos o professor encontrado
        } catch (JwtException | AuthenticationException e) { // Capturamos exceções específicas
            e.printStackTrace(); // Logamos o erro para depuração
            return ResponseEntity.status(401).build(); // Retornamos status 401 (não autorizado)
        }
    }

    @GetMapping("buscarProfessor")
    public ResponseEntity<Professor> buscarProfessor(@RequestParam Long id) {
        // Este método não foi alterado, mas pode ser refatorado se necessário
        return ResponseEntity.ok(professorServices.buscarProfessor(id));
    }

    @PutMapping("atualizarProfessor")
    public ResponseEntity<Professor> atualizarProfessor(@RequestParam Long id, @RequestBody Professor professor) {
        professorServices.atualizarProfessor(id, professor);
        Professor professorAtualizado = professorServices.findById(id);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("deletarProfessor")
    public ResponseEntity<Void> deletarProfessor(@RequestParam Long id) {
        professorServices.deletarProfessorPorId(id);
        return ResponseEntity.noContent().build();
    }

    // Método privado para validar e codificar a senha do professor
    private void validateAndEncodePassword(Professor professor) {
        if (professor.getSenha() != null && !professor.getSenha().isBlank()) {
            professor.setSenha(passwordEncoder.encode(professor.getSenha())); // Codificamos a senha
        }
    }

    // Método privado para extrair o e-mail do cabeçalho de autorização
    private String extractEmailFromAuthHeader(String authHeader) {
        String token = authHeader.replace("Bearer ", ""); // Removemos o prefixo "Bearer " do token
        return jwtService.extractUsername(token); // Extraímos o e-mail do token usando o serviço JWT
    }
}