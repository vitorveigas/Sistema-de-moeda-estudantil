package com.lab.sistema_de_moedas.service;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.model.Transacao;
import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;
import com.lab.sistema_de_moedas.repository.VantagemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VantagemService {

    private final VantagemRepository vantagemRepository;
    private final EmpresaRepositories empresaRepository;
    private final AlunoServices alunoServices;
    private final TransacaoService transacaoService;

    // ✅ Corrigido: construtor injeta corretamente os serviços necessários
    public VantagemService(
            VantagemRepository vantagemRepository,
            EmpresaRepositories empresaRepository,
            AlunoServices alunoServices,
            TransacaoService transacaoService) {

        this.vantagemRepository = vantagemRepository;
        this.empresaRepository = empresaRepository;
        this.alunoServices = alunoServices;
        this.transacaoService = transacaoService;
    }

    public Vantagem cadastrarVantagem(Long empresaId, Vantagem vantagem) {
        if (empresaId == null) {
            throw new IllegalArgumentException("O ID da empresa não pode ser nulo!");
        }

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada!"));

        vantagem.setEmpresa(empresa);
        return vantagemRepository.save(vantagem);
    }

    public List<Vantagem> listarTodasVantagens() {
        return vantagemRepository.findAll();
    }

    public List<Vantagem> listarPorEmpresa(Long empresaId) {
        return vantagemRepository.findByEmpresaId(empresaId);
    }

    // ✅ Busca vantagem por ID
    public Vantagem buscarPorId(Long id) {
        return vantagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vantagem não encontrada!"));
    }

    // ✅ Troca de vantagem (aluno gasta moedas)
    public Transacao trocarVantagem(Aluno aluno, Vantagem vantagem) {
        if (aluno == null) throw new IllegalArgumentException("Aluno não encontrado");
        if (vantagem == null) throw new IllegalArgumentException("Vantagem inválida");

        // Verifica saldo
        if (aluno.getSaldoMoedas() < vantagem.getCustoMoedas()) {
            throw new IllegalArgumentException("Saldo insuficiente para trocar por esta vantagem!");
        }

        // Deduz o custo da vantagem
        aluno.setSaldoMoedas(aluno.getSaldoMoedas() - vantagem.getCustoMoedas());
        alunoServices.salvarAluno(aluno);

        // Cria e salva a transação
        Transacao transacao = new Transacao();
        transacao.setAluno(aluno);
        transacao.setDescricao("Troca pela vantagem: " + vantagem.getTitulo());
        transacao.setValor(-vantagem.getCustoMoedas());
        transacao.setData(LocalDateTime.now());

        return transacaoService.salvarTransacao(transacao);
    }
}
