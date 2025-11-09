package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.service.VantagemService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vantagens")
public class VantagemController {

    private final VantagemService vantagemService;

    public VantagemController(VantagemService vantagemService) {
        this.vantagemService = vantagemService;
    }

    // Caso de uso 1 — Empresa cadastra vantagem
    @PostMapping("/criar")
    public ResponseEntity<?> criarVantagem(@RequestBody VantagemRequest req) {
        try {
            if (req.getEmpresaId() == null || req.getTitulo() == null || req.getTitulo().isEmpty()) {
                return ResponseEntity.badRequest().body("Campos obrigatórios não informados!");
            }

            Vantagem v = Vantagem.builder()
                    .titulo(req.getTitulo())
                    .descricao(req.getDescricao())
                    .custoMoedas(req.getCustoMoedas())
                    .build();

            Vantagem salva = vantagemService.cadastrarVantagem(req.getEmpresaId(), v);
            return ResponseEntity.ok(salva);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Caso de uso 2 — Aluno lista todas as vantagens
    @GetMapping("/listar")
    public ResponseEntity<List<Vantagem>> listarVantagens() {
        List<Vantagem> vantagens = vantagemService.listarTodasVantagens();
        return ResponseEntity.ok(vantagens);
    }

    // Extra — Listar vantagens de uma empresa
    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<Vantagem>> listarPorEmpresa(@PathVariable Long id) {
        List<Vantagem> vantagens = vantagemService.listarPorEmpresa(id);
        return ResponseEntity.ok(vantagens);
    }

    @Data
    public static class VantagemRequest {
        private Long empresaId;
        private String titulo;
        private String descricao;
        private int custoMoedas;
    }
}
