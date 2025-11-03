package com.lab.sistema_de_moedas.config;

import com.lab.sistema_de_moedas.service.ProfessorCoinService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CoinDataInitializer implements ApplicationRunner {

    private final ProfessorCoinService coinService;
    // 1000 por semestre
    private static final long INITIAL_COINS = 1000L;

    public CoinDataInitializer(ProfessorCoinService coinService) {
        this.coinService = coinService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        coinService.addSemesterCoinsToAllProfessors(INITIAL_COINS);
        System.out.println("Adicionados " + INITIAL_COINS + " moedas a cada professor (startup).");
    }
}