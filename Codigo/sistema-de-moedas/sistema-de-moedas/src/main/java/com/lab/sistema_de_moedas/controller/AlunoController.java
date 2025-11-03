package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.service.AlunoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoServices alunoServices;

    private final com.lab.sistema_de_moedas.service.JwtService jwtService;

    @GetMapping("/buscarPorMatricula")
    public ResponseEntity<Aluno> buscarPorMatricula(@RequestParam String matricula) {
        Aluno aluno = alunoServices.buscarAlunoPorMatricula(matricula);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno);
    }

    @PostMapping("criarAluno")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno){
            
        alunoServices.salvarAluno(aluno);

        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/perfil")
    public ResponseEntity<Aluno> perfil(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String email = jwtService.extractUsername(token);
            Aluno aluno = alunoServices.buscarAlunoPorEmail(email);
            return ResponseEntity.ok(aluno);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build(); // Não autorizado
        }
    }

    @GetMapping("buscarAluno")
    public ResponseEntity<Aluno> buscarAluno(@RequestParam Long id){
        Aluno aluno = alunoServices.buscarAlunoPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("buscarPorCpf")
    public ResponseEntity<Aluno> buscarPorCpf(@RequestParam String cpf){
        System.out.println("Buscando aluno com CPF: " + cpf);
        try {
            Aluno aluno = alunoServices.buscarAlunoPorCpf(cpf);
            System.out.println("Aluno encontrado: " + aluno.getNome());
            return ResponseEntity.ok(aluno);
        } catch (Exception e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("atualizarAluno")
    public ResponseEntity<Aluno> atualizarAluno(@RequestParam Long id, @RequestBody Aluno aluno){
        alunoServices.atualizarAluno(id, aluno);
        Aluno alunoAtualizado = alunoServices.buscarAlunoPorId(id);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @PutMapping("atualizarPorCpf")
    public ResponseEntity<Aluno> atualizarPorCpf(@RequestParam String cpf, @RequestBody Aluno aluno){
        alunoServices.atualizarAlunoPorCpf(cpf, aluno);
        Aluno alunoAtualizado = alunoServices.buscarAlunoPorCpf(cpf);
        return ResponseEntity.ok(alunoAtualizado);
    }
    
    @DeleteMapping("deletarAluno")
    public ResponseEntity<Void> deletarAluno(@RequestParam Long id){
        alunoServices.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deletarPorCpf")
    public ResponseEntity<Void> deletarPorCpf(@RequestParam String cpf){
        System.out.println("Deletando aluno com CPF: " + cpf);
        try {
            alunoServices.deletarAlunoPorCpf(cpf);
            System.out.println("Aluno deletado com sucesso");
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
