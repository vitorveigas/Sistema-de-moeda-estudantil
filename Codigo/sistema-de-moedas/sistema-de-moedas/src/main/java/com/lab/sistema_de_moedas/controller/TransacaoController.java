package com.lab.sistema_de_moedas.controller;

import com.lab.sistema_de_moedas.model.Transacao;
import com.lab.sistema_de_moedas.service.ProfessorCoinService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final ProfessorCoinService coinService;

    public TransacaoController(ProfessorCoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarMoedas(@RequestBody TransferRequest req) {
        try {
            Transacao t = coinService.transferCoins(req.getProfessorId(), req.getAlunoId(), req.getQuantidade(), req.getMensagem());
            return ResponseEntity.ok(t);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/professor/{id}/saldo")
    public ResponseEntity<?> saldoProfessor(@PathVariable Long id) {
        return ResponseEntity.of(coinService.getProfessorBalance(id));
    }

    @GetMapping("/aluno/{id}/saldo")
    public ResponseEntity<?> saldoAluno(@PathVariable Long id) {
        return ResponseEntity.of(coinService.getAlunoBalance(id));
    }

    @Data
    public static class TransferRequest {
        private Long professorId;
        private Long alunoId;
        private Long quantidade;
        private String mensagem;
    }
}