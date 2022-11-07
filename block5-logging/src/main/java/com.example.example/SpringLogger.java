package com.example.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLogger implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(SpringLogger.class);

    public String generateLogs(String... args){

        SpringApplication.run(ExampleApplication.class, args);
        //ordenados de mayor a menor importancia
        logger.error("Esto es un error");
        logger.warn("Esto es un warning");
        logger.info("Esto es un info");
        logger.debug("Esto es un debug");
        logger.trace("Esto es un trace");


        return "Hola! Mira los logs para ver los resultados";
    }
    @Override
    public void run(String... args) throws Exception {}
}
