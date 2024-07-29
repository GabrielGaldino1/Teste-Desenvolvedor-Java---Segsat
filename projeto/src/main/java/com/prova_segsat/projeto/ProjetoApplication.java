package com.prova_segsat.projeto;

import com.prova_segsat.projeto.service.AdSetApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

    @Autowired
    private AdSetApiService adSetApiService;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        adSetApiService.consumeAndStoreData();
    }
}
