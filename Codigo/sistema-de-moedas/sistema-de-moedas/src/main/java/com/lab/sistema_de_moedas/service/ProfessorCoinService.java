package com.lab.sistema_de_moedas.service;

import com.lab.sistema_de_moedas.model.*;
import com.lab.sistema_de_moedas.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorCoinService {

    private final ProfessorRepositories professorRepo;
    private final AlunoRepositories alunoRepo;
    private final ProfessorBalanceRepository professorBalanceRepo;
    private final AlunoBalanceRepository alunoBalanceRepo;
    private final TransacaoRepository transacaoRepo;

    public ProfessorCoinService(ProfessorRepositories professorRepo,
                                AlunoRepositories alunoRepo,
                                ProfessorBalanceRepository professorBalanceRepo,
                                AlunoBalanceRepository alunoBalanceRepo,
                                TransacaoRepository transacaoRepo) {
        this.professorRepo = professorRepo;
        this.alunoRepo = alunoRepo;
        this.professorBalanceRepo = professorBalanceRepo;
        this.alunoBalanceRepo = alunoBalanceRepo;
        this.transacaoRepo = transacaoRepo;
    }

    // adiciona 1000 moedas a todos os professores (executar no startup)
    @Transactional
    public void addSemesterCoinsToAllProfessors(long amount) {
        List<Professor> todos = professorRepo.findAll();
        for (Professor p : todos) {
            ProfessorBalance pb = professorBalanceRepo.findByProfessor(p)
                    .orElseGet(() -> {
                        ProfessorBalance nb = new ProfessorBalance();
                        nb.setProfessor(p);
                        nb.setBalance(0L);
                        return nb;
                    });
            pb.setBalance(pb.getBalance() + amount);
            professorBalanceRepo.save(pb);
        }
    }

    // envia moedas de professor para aluno com mensagem obrigatória
    @Transactional
    public Transacao transferCoins(Long professorId, Long alunoId, Long quantidade, String mensagem) {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("Mensagem obrigatória");
        }

        Professor professor = professorRepo.findById(professorId)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
        Aluno aluno = alunoRepo.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        ProfessorBalance pb = professorBalanceRepo.findByProfessor(professor)
                .orElseThrow(() -> new IllegalArgumentException("Saldo do professor não encontrado"));

        if (pb.getBalance() < quantidade) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        // débito professor
        pb.setBalance(pb.getBalance() - quantidade);
        professorBalanceRepo.save(pb);

        // crédito aluno
        AlunoBalance ab = alunoBalanceRepo.findByAluno(aluno)
                .orElseGet(() -> {
                    AlunoBalance nab = new AlunoBalance();
                    nab.setAluno(aluno);
                    nab.setBalance(0L);
                    return nab;
                });
        ab.setBalance(ab.getBalance() + quantidade);
        alunoBalanceRepo.save(ab);

        // registra transação
        Transacao t = Transacao.builder()
                .professor(professor)
                .aluno(aluno)
                .quantidade(quantidade)
                .mensagem(mensagem)
                .build();
        return transacaoRepo.save(t);
    }

    public Optional<ProfessorBalance> getProfessorBalance(Long professorId) {
        return professorRepo.findById(professorId).flatMap(professorBalanceRepo::findByProfessor);
    }

    public Optional<AlunoBalance> getAlunoBalance(Long alunoId) {
        return alunoRepo.findById(alunoId).flatMap(alunoBalanceRepo::findByAluno);
    }

    public List<Transacao> getHistoricoAluno(Long alunoId) {
        if (alunoId == null) {
            throw new IllegalArgumentException("ID do aluno não pode ser nulo");
        }
        return transacaoRepo.findAllByAlunoIdOrderByCriadoEmDesc(alunoId);
    }
}