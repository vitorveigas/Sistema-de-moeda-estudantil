package com.lab.sistema_de_moedas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.sistema_de_moedas.model.Empresa;
import com.lab.sistema_de_moedas.service.EmpresaServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {
    
    private final EmpresaServices empresaServices;

    @PostMapping("/criarEmpresa")
    public ResponseEntity<Empresa> criarEmpresa(Empresa empresa) {
        empresaServices.salvarEmpresa(empresa);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/buscarPorCnpj")
    public ResponseEntity<Empresa> buscarPorCnpj(@RequestParam String cnpj) {
        Empresa empresa = empresaServices.buscarEmpresaPorCnpj(cnpj);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/buscarPorId")
    public ResponseEntity<Empresa> buscarPorId(@RequestParam Long id) {
        Empresa empresa = empresaServices.buscarEmpresaPorId(id);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("atualizarEmpresa/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresaServices.atualizarEmpresa(id, empresa);
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/deletarPorCnpj")
    public ResponseEntity<String> deletarPorCnpj(@RequestParam String cnpj) {
        empresaServices.deletarEmpresaPorCnpj(cnpj);
        return ResponseEntity.ok("Empresa deletada com sucesso");
    }

    @DeleteMapping("/deletarPorId")
    public ResponseEntity<String> deletarPorId(@RequestParam Long id) {
        empresaServices.deletarEmpresaPorId(id);
        return ResponseEntity.ok("Empresa deletada com sucesso");
    }

    
}
