package com.lab.sistema_de_moedas.config;

import com.lab.sistema_de_moedas.model.Professor;
import com.lab.sistema_de_moedas.service.ProfessorServices;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private final ProfessorServices professorServices;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(ProfessorServices professorServices, PasswordEncoder passwordEncoder) {
        this.professorServices = professorServices;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String email = "professor.inicial@escola.edu.br";

        // evita duplicata
        if (professorServices.findByEmail(email) == null) {
            Professor professor = new Professor();
            professor.setNome("Professor Inicial");
            professor.setEmail(email);
            professor.setSenha(passwordEncoder.encode("senhaSegura123"));
            professor.setCpf("000.000.000-00");
            professor.setDepartamento("Matemática");

            professorServices.criarProfessor(professor);
            System.out.println("Professor inicial criado: " + email);
        } else {
            System.out.println("Professor inicial já existe: " + email);
        }
    }
}