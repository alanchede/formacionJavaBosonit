package com.example.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertiesResources implements CommandLineRunner {

    @Value("${greeting}")
    private String greeting;
    @Value("${my.number}")
    private String myNumber;
    @Value("${new.property:sin valor}")
    private String newProperty;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de greeting es: " + greeting);
        System.out.println("El valor de my.number es: " + myNumber);
        System.out.println("El valor de new.property es: " + newProperty);
    }
}

