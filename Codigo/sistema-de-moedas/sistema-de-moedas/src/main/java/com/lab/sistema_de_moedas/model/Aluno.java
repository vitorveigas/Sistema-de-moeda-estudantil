package com.lab.sistema_de_moedas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Aluno extends Usuario {
    
    private String matricula;
    private String curso;
    private String cpf;
    private String rg;
    private String instituicaoEnsino;
    private String endereco;
    

    
}