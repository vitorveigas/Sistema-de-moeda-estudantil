package com.lab.sistema_de_moedas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_moedas.model.Transacao;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Transacao findById(long id);
    List<Transacao> findAllByAlunoIdOrderByCriadoEmDesc(Long alunoId);
    List<Transacao> findAllByAlunoId(Long alunoId);
}