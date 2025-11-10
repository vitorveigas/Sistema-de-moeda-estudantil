package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.model.Transacao;
import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.service.AlunoServices;
import com.lab.sistema_de_moedas.service.JwtService;
import com.lab.sistema_de_moedas.service.VantagemService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vantagens")
public class VantagemController {

    private final VantagemService vantagemService;
    private final JwtService jwtService;
    private final AlunoServices alunoServices;

    // ✅ Construtor corrigido com todas as dependências injetadas
    public VantagemController(VantagemService vantagemService, JwtService jwtService, AlunoServices alunoServices) {
        this.vantagemService = vantagemService;
        this.jwtService = jwtService;
        this.alunoServices = alunoServices;
    }

    // ✅ Caso de uso 1 — Empresa cadastra vantagem
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

    // ✅ Caso de uso 2 — Aluno lista todas as vantagens
    @GetMapping("/listar")
    public ResponseEntity<List<Vantagem>> listarVantagens() {
        List<Vantagem> vantagens = vantagemService.listarTodasVantagens();
        return ResponseEntity.ok(vantagens);
    }

    // ✅ Extra — Listar vantagens de uma empresa
    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<Vantagem>> listarPorEmpresa(@PathVariable Long id) {
        List<Vantagem> vantagens = vantagemService.listarPorEmpresa(id);
        return ResponseEntity.ok(vantagens);
    }

    // ✅ Caso de uso 3 — Aluno troca vantagem (usa JWT)
    @PostMapping("/trocar/{vantagemId}")
    public ResponseEntity<?> trocarVantagem(
            @PathVariable Long vantagemId,
            @RequestHeader("Authorization") String authHeader) {
        try {
            // Extrai o e-mail do aluno a partir do token JWT
            String token = authHeader.replace("Bearer ", "");
            String email = jwtService.extractUsername(token);
            Aluno aluno = alunoServices.buscarAlunoPorEmail(email);

            // Busca a vantagem
            Vantagem vantagem = vantagemService.buscarPorId(vantagemId);

            // Realiza a troca e gera a transação
            Transacao transacao = vantagemService.trocarVantagem(aluno, vantagem);

            return ResponseEntity.ok(transacao);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro interno ao realizar a troca.");
        }
    }

    @Data
    public static class VantagemRequest {
        private Long empresaId;
        private String titulo;
        private String descricao;
        private int custoMoedas;
    }
}
