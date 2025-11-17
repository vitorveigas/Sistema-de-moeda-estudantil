    package com.lab.sistema_de_moedas.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.experimental.SuperBuilder;

    import java.time.Instant;
import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @SuperBuilder
    public class Transacao {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "professor_id")
        private Professor professor;

        @ManyToOne(optional = false)
        @JoinColumn(name = "aluno_id")
        private Aluno aluno;

        @Column(nullable = false)
        private Long quantidade;

        @Column(nullable = false, length = 1000)
        private String mensagem;

        private Instant criadoEm = Instant.now();

        public void setCriadoEm(LocalDateTime now) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setCriadoEm'");
        }
    }