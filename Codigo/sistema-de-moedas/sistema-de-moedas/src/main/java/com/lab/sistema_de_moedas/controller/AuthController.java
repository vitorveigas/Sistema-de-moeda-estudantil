package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.repository.AlunoRepositories;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;
import com.lab.sistema_de_moedas.repository.ProfessorRepositories; // Add this import
import com.lab.sistema_de_moedas.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AlunoRepositories alunoRepositories;
    private final EmpresaRepositories empresaRepositories;
    private final ProfessorRepositories professorRepositories; // Declare professorRepositories
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Tentar encontrar como Aluno
        Optional<Aluno> alunoOpt = alunoRepositories.findByEmail(request.getEmail());
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            if (passwordEncoder.matches(request.getPassword(), aluno.getSenha())) {
                String token = jwtService.generateToken(aluno.getEmail());
                response.put("token", token);
                response.put("userType", "ALUNO");
                response.put("user", aluno);
                return ResponseEntity.ok(response);
            }
        }

        // Tentar encontrar como Empresa
        Optional<Empresa> empresaOpt = empresaRepositories.findByEmail(request.getEmail());
        if (empresaOpt.isPresent()) {
            Empresa empresa = empresaOpt.get();
            if (passwordEncoder.matches(request.getPassword(), empresa.getSenha())) {
                String token = jwtService.generateToken(empresa.getEmail());
                response.put("token", token);
                response.put("userType", "EMPRESA");
                response.put("user", empresa);
                return ResponseEntity.ok(response);
            }
        }

        // Tentar encontrar como Professor
        Optional<Professor> professorOpt = professorRepositories.findByEmail(request.getEmail()); // Use the injected repository
        if (professorOpt.isPresent()) {
            Professor professor = professorOpt.get();
            if (passwordEncoder.matches(request.getPassword(), professor.getSenha())) {
                String token = jwtService.generateToken(professor.getEmail());
                response.put("token", token);
                response.put("userType", "PROFESSOR");
                response.put("user", professor);
                return ResponseEntity.ok(response);
            }
        }

        response.put("error", "Credenciais inválidas");
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/register/aluno")
    public ResponseEntity<Map<String, Object>> registerAluno(@RequestBody Aluno aluno) {
        Map<String, Object> response = new HashMap<>();
        
        if (alunoRepositories.findByEmail(aluno.getEmail()).isPresent()) {
            response.put("error", "Email já cadastrado");
            return ResponseEntity.badRequest().body(response);
        }
        
        aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
        alunoRepositories.save(aluno);
        
        String token = jwtService.generateToken(aluno.getEmail());
        response.put("token", token);
        response.put("userType", "ALUNO");
        response.put("user", aluno);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register/empresa")
    public ResponseEntity<Map<String, Object>> registerEmpresa(@RequestBody Empresa empresa) {
        Map<String, Object> response = new HashMap<>();
        
        if (empresaRepositories.findByEmail(empresa.getEmail()).isPresent()) {
            response.put("error", "Email já cadastrado");
            return ResponseEntity.badRequest().body(response);
        }
        
        empresa.setSenha(passwordEncoder.encode(empresa.getSenha()));
        empresaRepositories.save(empresa);
        
        String token = jwtService.generateToken(empresa.getEmail());
        response.put("token", token);
        response.put("userType", "EMPRESA");
        response.put("user", empresa);
        
        return ResponseEntity.ok(response);
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}