package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.service.JwtService;
import com.lab.sistema_de_moedas.service.ProfessorServices; // Ensure you have a ProfessorServices class
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorServices professorServices; // Ensure you have a ProfessorServices class

    @Autowired
    private JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("criarProfessor")
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        if (professor.getSenha() != null && !professor.getSenha().isBlank()) {
            professor.setSenha(passwordEncoder.encode(professor.getSenha()));
        }
        professorServices.criarProfessor(professor);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/perfil")
    public ResponseEntity<Professor> perfil(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String email = jwtService.extractUsername(token);
            Professor professor = professorServices.findByEmail(email);
            return ResponseEntity.ok(professor);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build(); // Não autorizado
        }
    }

    @GetMapping("buscarProfessor")
    public ResponseEntity<Professor> buscarProfessor(@RequestParam Long id) {
        Professor professor = professorServices.findById(id);
        return ResponseEntity.ok(professor);
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
}