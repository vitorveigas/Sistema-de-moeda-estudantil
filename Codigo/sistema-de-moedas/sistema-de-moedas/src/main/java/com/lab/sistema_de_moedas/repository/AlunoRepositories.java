package com.lab.sistema_de_moedas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.sistema_de_moedas.model.Aluno;

import jakarta.transaction.Transactional;
import java.util.List;


public interface AlunoRepositories extends JpaRepository<Aluno, Long> {
    
    Optional<Aluno> findById(Long id);
    Optional<Aluno> findByEmail(String email);
    Optional<Aluno> findByCpf(String cpf);

    @Transactional
    void deleteById(Long id);

    @Transactional
    void deleteByEmail(String email);

    @Transactional
    void deleteByCpf(String cpf);

    List<Aluno> findByMatricula(String matricula);
}
