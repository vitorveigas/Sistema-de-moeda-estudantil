package com.lab.sistema_de_moedas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_moedas.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}