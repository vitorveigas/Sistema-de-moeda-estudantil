package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Aluno;
import com.lab.sistema_de_moedas.model.AlunoBalance;
import com.lab.sistema_de_moedas.model.Transacao;
import com.lab.sistema_de_moedas.model.Vantagem;
import com.lab.sistema_de_moedas.service.AlunoServices;
import com.lab.sistema_de_moedas.service.JwtService;
import com.lab.sistema_de_moedas.service.VantagemService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;


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

    
    @PostMapping(value = "/criar-com-imagem", consumes = "multipart/form-data")
public ResponseEntity<?> criarComImagem(
        @RequestPart("vantagem") VantagemRequest req,
        @RequestPart("file") MultipartFile file) {

    try {
        if (req.getEmpresaId() == null || req.getTitulo() == null || req.getTitulo().isEmpty()) {
            return ResponseEntity.badRequest().body("Campos obrigatórios não informados!");
        }

        // 🔵 1 — Cria pasta uploads
        Files.createDirectories(Paths.get("uploads"));

        // 🔵 2 — Gera nome único
        String nome = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path caminho = Paths.get("uploads/" + nome);
        Files.write(caminho, file.getBytes());

        // 🔵 3 — Gera URL pública
        String urlImagem = "http://localhost:8080/uploads/" + nome;

        // 🔵 4 — Cria e salva vantagem
        Vantagem v = Vantagem.builder()
                .titulo(req.getTitulo())
                .descricao(req.getDescricao())
                .custoMoedas(req.getCustoMoedas())
                .img(urlImagem)
                .build();

        Vantagem salva = vantagemService.cadastrarVantagem(req.getEmpresaId(), v);

        return ResponseEntity.ok(salva);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("Erro ao criar vantagem com imagem.");
    }
}
@PostMapping("/criar-com-url")
public ResponseEntity<?> criarComUrl(@RequestBody VantagemRequest req) {
    try {
        if (req.getEmpresaId() == null || 
            req.getTitulo() == null || req.getTitulo().isEmpty()) {
            return ResponseEntity.badRequest().body("Campos obrigatórios não informados!");
        }

        Vantagem v = Vantagem.builder()
                .titulo(req.getTitulo())
                .descricao(req.getDescricao())
                .custoMoedas(req.getCustoMoedas())
                .img(req.getImg())   // 🔥 salva direto a URL recebida
                .build();

        Vantagem salva = vantagemService.cadastrarVantagem(req.getEmpresaId(), v);

        return ResponseEntity.ok(salva);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("Erro ao criar vantagem com URL.");
    }
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

        // Busca o aluno
        Aluno aluno = alunoServices.buscarAlunoPorEmail(email);

        // Busca o saldo do aluno
        AlunoBalance alunoBalance = alunoServices.buscarBalancePorAluno(aluno.getId());
        if (alunoBalance == null) {
            return ResponseEntity.badRequest().body("Saldo do aluno não encontrado");
        }

        // Busca a vantagem
        Vantagem vantagem = vantagemService.buscarPorId(vantagemId);

        // Verifica se o aluno tem saldo suficiente
        if (alunoBalance.getBalance() < vantagem.getCustoMoedas()) {
            return ResponseEntity.badRequest().body("Saldo insuficiente para trocar esta vantagem");
        }

        // Realiza a troca usando o service
        Transacao transacao = vantagemService.trocarVantagem(alunoBalance, vantagem);

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
        private String img;
    }
}
