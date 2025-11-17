package com.lab.sistema_de_moedas.service;

import com.lab.sistema_de_moedas.model.AlunoBalance;
import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.model.Transacao;
import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.repository.AlunoBalanceRepository;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;
import com.lab.sistema_de_moedas.repository.ProfessorRepositories;
import com.lab.sistema_de_moedas.repository.TransacaoRepository;
import com.lab.sistema_de_moedas.repository.VantagemRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class VantagemService {

    private final VantagemRepository vantagemRepository;
    private final AlunoBalanceRepository alunoBalanceRepository;
    private final ProfessorRepositories professorRepository;
    private final TransacaoRepository transacaoRepository;
    private final EmpresaRepositories empresaRepository;

    public VantagemService(
        VantagemRepository vantagemRepository,
        AlunoBalanceRepository alunoBalanceRepository,
        TransacaoRepository transacaoRepository,
        EmpresaRepositories empresaRepository,
        ProfessorRepositories professorRepository) {
    this.vantagemRepository = vantagemRepository;
    this.alunoBalanceRepository = alunoBalanceRepository;
    this.transacaoRepository = transacaoRepository;
    this.empresaRepository = empresaRepository;
    this.professorRepository = professorRepository;
}

    // Cadastra vantagem vinculada a empresa
    public Vantagem cadastrarVantagem(Long empresaId, Vantagem vantagem) {
        if (empresaId == null) {
            throw new IllegalArgumentException("O ID da empresa não pode ser nulo!");
        }

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada!"));

        vantagem.setEmpresa(empresa);
        return vantagemRepository.save(vantagem);
    }

    // Lista todas as vantagens
    public List<Vantagem> listarTodasVantagens() {
        return vantagemRepository.findAll();
    }

    // Lista vantagens de uma empresa específica
    public List<Vantagem> listarPorEmpresa(Long empresaId) {
        return vantagemRepository.findByEmpresaId(empresaId);
    }

    // Busca vantagem por ID
    public Vantagem buscarPorId(Long id) {
        return vantagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vantagem não encontrada!"));
    }

    public Transacao trocarVantagem(AlunoBalance alunoBalance, Vantagem vantagem) {
        if (alunoBalance == null) {
            throw new IllegalArgumentException("Saldo do aluno não encontrado");
        }

        if (alunoBalance.getBalance() < vantagem.getCustoMoedas()) {
            throw new IllegalArgumentException("Saldo insuficiente para trocar esta vantagem");
        }

        Professor professorSistema = professorRepository.findById(1L)
        .orElseThrow(() -> new IllegalStateException("Professor do sistema não encontrado"));

        // Atualiza o saldo do aluno
        alunoBalance.setBalance(alunoBalance.getBalance() - vantagem.getCustoMoedas());
        alunoBalanceRepository.save(alunoBalance);

        // Cria a transação de acordo com a model
        Transacao transacao = Transacao.builder()
                .professor(professorSistema) // ou pode criar um professor "sistema" se desejar
                .aluno(alunoBalance.getAluno())
                .quantidade((long) -vantagem.getCustoMoedas())
                .mensagem("Aluno trocou " + vantagem.getCustoMoedas() + " moedas pela vantagem '" + vantagem.getTitulo() + "'")
                .criadoEm(Instant.now())
                .build();

        return transacaoRepository.save(transacao);
    }

}
