package com.lab.sistema_de_moedas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.sistema_de_moedas.model.Professor;

public interface ProfessorRepositories extends JpaRepository<Professor, Long> {
    Professor findByCpf(String cpf);
    Optional<Professor> findById(Long id);
    Professor findByDepartamento(String departamento);
    Optional<Professor> findByEmail(String email);

    
}
