package com.lab.sistema_de_moedas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_moedas.model.AlunoBalance;
import com.lab.sistema_de_moedas.model.Aluno;

public interface AlunoBalanceRepository extends JpaRepository<AlunoBalance, Long> {
    Optional<AlunoBalance> findByAluno(Aluno aluno);
}