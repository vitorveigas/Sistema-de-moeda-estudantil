package com.lab.sistema_de_moedas.service;

import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;
import com.lab.sistema_de_moedas.repository.VantagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VantagemService {

    private final VantagemRepository vantagemRepository;
    private final EmpresaRepositories empresaRepository;

    public VantagemService(VantagemRepository vantagemRepository, EmpresaRepositories empresaRepository) {
        this.vantagemRepository = vantagemRepository;
        this.empresaRepository = empresaRepository;
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
}
