package com.lab.sistema_de_moedas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.repository.EmpresaRepositories;

@Service
public class EmpresaServices {
    
    @Autowired
    private EmpresaRepositories empresaRepositories;

    public void salvarEmpresa(Empresa empresa){
        empresaRepositories.saveAndFlush(empresa);
    }

    public void deletarEmpresaPorId(Long Id){
        empresaRepositories.deleteById(Id);
    }

    public void deletarEmpresaPorCnpj(String cnpj){
        empresaRepositories.deleteByCnpj(cnpj);
    }

    public Empresa buscarEmpresaPorId(Long id){
        return empresaRepositories.findById(id)
        .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
    }

    public void atualizarEmpresa(Long id, Empresa empresa){
       Empresa empresaAtual = buscarEmpresaPorId(id);
       Empresa empresaAtualizada = Empresa.builder()
        .id(empresaAtual.getId())
        .nome(empresa.getNome() != null ? empresa.getNome() : empresaAtual.getNome())
        .email(empresa.getEmail() != null ? empresa.getEmail() : empresaAtual.getEmail())
        .senha(empresa.getSenha() != null ? empresa.getSenha() : empresaAtual.getSenha())
        .cnpj(empresa.getCnpj() != null ? empresa.getCnpj() : empresaAtual.getCnpj())
        .endereco(empresa.getEndereco() != null ? empresa.getEndereco() : empresaAtual.getEndereco())
        .build();
         
        empresaRepositories.saveAndFlush(empresaAtualizada);
    }

    public Empresa buscarEmpresaPorCnpj(String cnpj){
        return empresaRepositories.findByCnpj(cnpj)
        .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
    }
    
}
