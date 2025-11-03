package com.lab.sistema_de_moedas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_moedas.model.ProfessorBalance;
import com.lab.sistema_de_moedas.model.Professor;

public interface ProfessorBalanceRepository extends JpaRepository<ProfessorBalance, Long> {
    Optional<ProfessorBalance> findByProfessor(Professor professor);
}