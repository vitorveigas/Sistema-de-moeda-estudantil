package com.lab.sistema_de_moedas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.repository.ProfessorRepositories;

@Service
public class ProfessorServices {

    @Autowired
    private ProfessorRepositories professorRepositories;   

    public Professor findByCpf(String cpf) {    
        return professorRepositories.findByCpf(cpf);
    }

    public void criarProfessor(Professor professor) {
        professorRepositories.save(professor);
    }

    public Professor findByDepartamento(String departamento) {
        return professorRepositories.findByDepartamento(departamento);
    }

    public Professor findById(Long id) {
        return professorRepositories.findById(id).orElse(null);
    }

    public void deletarProfessorPorId(Long id) {
        professorRepositories.deleteById(id);
    }

    public void atualizarProfessor(Long id, Professor professor) {
        Professor professorAtual = findById(id);
        if (professorAtual != null) {
            Professor professorAtualizado = Professor.builder()
                .id(professorAtual.getId())
                .nome(professor.getNome() != null ? professor.getNome() : professorAtual.getNome())
                .email(professor.getEmail() != null ? professor.getEmail() : professorAtual.getEmail())
                .senha(professor.getSenha() != null ? professor.getSenha() : professorAtual.getSenha())
                .cpf(professor.getCpf() != null ? professor.getCpf() : professorAtual.getCpf())
                .departamento(professor.getDepartamento() != null ? professor.getDepartamento() : professorAtual.getDepartamento())
                .build();
            professorRepositories.saveAndFlush(professorAtualizado);
        }
    }

    public void atualizarProfessorPorCpf(String cpf, Professor professor) {
        Professor professorAtual = findByCpf(cpf);
        if (professorAtual != null) {
            Professor professorAtualizado = Professor.builder()
                .id(professorAtual.getId())
                .nome(professor.getNome() != null ? professor.getNome() : professorAtual.getNome())
                .email(professor.getEmail() != null ? professor.getEmail() : professorAtual.getEmail())
                .senha(professor.getSenha() != null ? professor.getSenha() : professorAtual.getSenha())
                .cpf(professor.getCpf() != null ? professor.getCpf() : professorAtual.getCpf())
                .departamento(professor.getDepartamento() != null ? professor.getDepartamento() : professorAtual.getDepartamento())
                .build();
            professorRepositories.saveAndFlush(professorAtualizado);
        }
    }

    public void deletarProfessorPorCpf(String cpf) {
        Professor professor = findByCpf(cpf);
        if (professor != null) {
            professorRepositories.delete(professor);
        }
    }

    public void buscarProfessorPorId(Long id) {
        professorRepositories.findById(id).ifPresent(professor -> {
            // Lógica adicional, se necessário
        }); 
    }

    public Professor findByEmail(String email) {
        return professorRepositories.findByEmail(email).orElse(null);
    }


    
    
}
