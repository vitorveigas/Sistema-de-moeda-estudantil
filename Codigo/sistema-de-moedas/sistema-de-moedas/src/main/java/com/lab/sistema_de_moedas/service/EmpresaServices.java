package com.lab.sistema_de_moedas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;

@Service
public class EmpresaServices {
    
    @Autowired
    private EmpresaRepositories empresaRepositories;

    public void salvar(Empresa empresa){
        empresaRepositories.saveAndFlush(empresa);
    }

    public Empresa buscarPorId(Long id){
        return empresaRepositories.findById(id)
        .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
    }

    public Empresa buscarPorCnpj(String cnpj){
        return empresaRepositories.findByCnpj(cnpj)
        .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
    }

    public Empresa buscarPorEmail(String email){
        return empresaRepositories.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }

    public void deletarPorId(Long id){
        empresaRepositories.deleteById(id);
    }

    public void deletarPorCnpj(String cnpj){
        empresaRepositories.deleteByCnpj(cnpj);
    }

    public void atualizarPorCnpj(String cnpj, Empresa empresa){
        Empresa empresaAtual = buscarPorCnpj(cnpj);
        Empresa empresaAtualizada = Empresa.builder()
            .id(empresaAtual.getId())
            .nome(empresa.getNome() != null ? empresa.getNome() : empresaAtual.getNome())
            .email(empresa.getEmail() != null ? empresa.getEmail() : empresaAtual.getEmail())
            .senha(empresa.getSenha() != null ? empresa.getSenha() : empresaAtual.getSenha())
            .cnpj(empresa.getCnpj() != null ? empresa.getCnpj() : empresaAtual.getCnpj())
            .razaoSocial(empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : empresaAtual.getRazaoSocial())
            .endereco(empresa.getEndereco() != null ? empresa.getEndereco() : empresaAtual.getEndereco())
            .build();
             
        empresaRepositories.saveAndFlush(empresaAtualizada);
    }
}
