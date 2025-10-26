package com.lab.sistema_de_moedas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.repository.AlunoRepositories;

@Service
public class AlunoServices {
    
    @Autowired
    private AlunoRepositories alunoRepositories;

    public void salvarAluno(Aluno aluno){
        alunoRepositories.saveAndFlush(aluno);
    }

    public void deletarAlunoPorId(Long Id){
        alunoRepositories.deleteById(Id);
    }

    public void deletarAlunoPorEmail(String email){
        alunoRepositories.deleteByEmail(email);
    }

    public Aluno buscarAlunoPorId(Long id){
        return alunoRepositories.findById(id)
        .orElseThrow(()-> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno buscarAlunoPorCpf(String cpf){
        return alunoRepositories.findByCpf(cpf)
        .orElseThrow(()-> new RuntimeException("Aluno não encontrado"));
    }

    
            public void atualizarAluno(Long id, Aluno aluno){
               Aluno alunoAtual = buscarAlunoPorId(id);
               Aluno alunoAtualizado = Aluno.builder()
                .id(alunoAtual.getId())
                .nome(aluno.getNome() != null ? aluno.getNome() : alunoAtual.getNome())
                .email(aluno.getEmail() != null ? aluno.getEmail() : alunoAtual.getEmail())
                .senha(aluno.getSenha() != null ? aluno.getSenha() : alunoAtual.getSenha())
                .matricula(aluno.getMatricula() != null ? aluno.getMatricula() : alunoAtual.getMatricula())
                .curso(aluno.getCurso() != null ? aluno.getCurso() : alunoAtual.getCurso())
                .cpf(aluno.getCpf() != null ? aluno.getCpf() : alunoAtual.getCpf())
                .rg(aluno.getRg() != null ? aluno.getRg() : alunoAtual.getRg())
                .instituicaoEnsino(aluno.getInstituicaoEnsino() != null ? aluno.getInstituicaoEnsino() : alunoAtual.getInstituicaoEnsino())
                .endereco(aluno.getEndereco() != null ? aluno.getEndereco() : alunoAtual.getEndereco())
                .build();
                 
                alunoRepositories.saveAndFlush(alunoAtualizado);
            }

    public void atualizarAlunoPorCpf(String cpf, Aluno aluno){
        Aluno alunoAtual = buscarAlunoPorCpf(cpf);
        Aluno alunoAtualizado = Aluno.builder()
            .id(alunoAtual.getId())
            .nome(aluno.getNome() != null ? aluno.getNome() : alunoAtual.getNome())
            .email(aluno.getEmail() != null ? aluno.getEmail() : alunoAtual.getEmail())
            .senha(aluno.getSenha() != null ? aluno.getSenha() : alunoAtual.getSenha())
            .matricula(aluno.getMatricula() != null ? aluno.getMatricula() : alunoAtual.getMatricula())
            .curso(aluno.getCurso() != null ? aluno.getCurso() : alunoAtual.getCurso())
            .cpf(aluno.getCpf() != null ? aluno.getCpf() : alunoAtual.getCpf())
            .rg(aluno.getRg() != null ? aluno.getRg() : alunoAtual.getRg())
            .instituicaoEnsino(aluno.getInstituicaoEnsino() != null ? aluno.getInstituicaoEnsino() : alunoAtual.getInstituicaoEnsino())
            .endereco(aluno.getEndereco() != null ? aluno.getEndereco() : alunoAtual.getEndereco())
            .build();
             
        alunoRepositories.saveAndFlush(alunoAtualizado);
    }

    public void deletarAlunoPorCpf(String cpf){
        alunoRepositories.deleteByCpf(cpf);
    }
    public Aluno buscarAlunoPorEmail(String email) {
        return alunoRepositories.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
    
}