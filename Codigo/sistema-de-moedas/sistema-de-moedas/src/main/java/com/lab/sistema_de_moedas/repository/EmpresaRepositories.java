package com.lab.sistema_de_moedas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.sistema_de_moedas.model.Empresa;

import jakarta.transaction.Transactional;

public interface EmpresaRepositories extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findById(Long id);
    Optional<Empresa> findByCnpj(String cnpj);

    @Transactional
    void deleteById(Long id);

    @Transactional
    void deleteByCnpj(String cnpj);

    
}
