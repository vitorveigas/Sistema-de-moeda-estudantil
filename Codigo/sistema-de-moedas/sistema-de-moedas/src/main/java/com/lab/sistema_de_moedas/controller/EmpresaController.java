package com.lab.sistema_de_moedas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.service.EmpresaServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaServices empresaServices;

    @PostMapping("criar")
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa){
        empresaServices.salvar(empresa);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("buscar")
    public ResponseEntity<Empresa> buscar(@RequestParam Long id){
        return ResponseEntity.ok(empresaServices.buscarPorId(id));
    }

    @GetMapping("buscarPorCnpj")
    public ResponseEntity<Empresa> buscarPorCnpj(@RequestParam String cnpj){
        return ResponseEntity.ok(empresaServices.buscarPorCnpj(cnpj));
    }

    @PutMapping("atualizar")
    public ResponseEntity<Empresa> atualizar(@RequestParam Long id, @RequestBody Empresa empresa){
        Empresa atual = empresaServices.buscarPorId(id);
        Empresa nova = Empresa.builder()
            .id(atual.getId())
            .nome(empresa.getNome() != null ? empresa.getNome() : atual.getNome())
            .email(empresa.getEmail() != null ? empresa.getEmail() : atual.getEmail())
            .senha(empresa.getSenha() != null ? empresa.getSenha() : atual.getSenha())
            .cnpj(empresa.getCnpj() != null ? empresa.getCnpj() : atual.getCnpj())
            .razaoSocial(empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : atual.getRazaoSocial())
            .endereco(empresa.getEndereco() != null ? empresa.getEndereco() : atual.getEndereco())
            .build();
        empresaServices.salvar(nova);
        return ResponseEntity.ok(nova);
    }

    @PutMapping("atualizarPorCnpj")
    public ResponseEntity<Empresa> atualizarPorCnpj(@RequestParam String cnpj, @RequestBody Empresa empresa){
        empresaServices.atualizarPorCnpj(cnpj, empresa);
        Empresa empresaAtualizada = empresaServices.buscarPorCnpj(cnpj);
        return ResponseEntity.ok(empresaAtualizada);
    }

    @DeleteMapping("deletar")
    public ResponseEntity<Void> deletar(@RequestParam Long id){
        empresaServices.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deletarPorCnpj")
    public ResponseEntity<Void> deletarPorCnpj(@RequestParam String cnpj){
        empresaServices.deletarPorCnpj(cnpj);
        return ResponseEntity.noContent().build();
    }
}
