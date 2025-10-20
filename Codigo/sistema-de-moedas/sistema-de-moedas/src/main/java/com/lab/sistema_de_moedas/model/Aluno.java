package com.lab.sistema_de_moedas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)

public class Aluno extends Usuario {
    
    

    private String matricula;
    private String curso;
    private String cpf;
    private String rg;
    private String instituicaoEnsino;
    private String endereco;
    

    
}