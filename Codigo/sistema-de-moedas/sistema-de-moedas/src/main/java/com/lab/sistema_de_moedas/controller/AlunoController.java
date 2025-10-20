package com.lab.sistema_de_moedas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.service.AlunoServices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {
    
    private final AlunoServices alunoServices;

    @PostMapping("criarAluno")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno){
            
        alunoServices.salvarAluno(aluno);

        return ResponseEntity.ok(aluno);
    }

    @GetMapping("buscarAluno")
    public ResponseEntity<Aluno> buscarAluno(@RequestParam Long id){
        Aluno aluno = alunoServices.buscarAlunoPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("atualizarAluno")
    public ResponseEntity<Aluno> atualizarAluno(@RequestParam Long id, @RequestBody Aluno aluno){
        alunoServices.atualizarAluno(id, aluno);
        Aluno alunoAtualizado = alunoServices.buscarAlunoPorId(id);
        return ResponseEntity.ok(alunoAtualizado);
    }
    
    @DeleteMapping("deletarAluno")
    public ResponseEntity<Void> deletarAluno(@RequestParam Long id){
        alunoServices.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }
    
}
