package com.lab.sistema_de_moedas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario {
    
    private String cnpj;
    private String endereco;

}
