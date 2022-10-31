package com.example.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class YmlResources implements CommandLineRunner {

    @Value("${ymlgreeting}")
    private String ymlGreeting;
    @Value("${my.ymlnumber}")
    private String ymlMyNumber;
    @Value("${new.ymlproperty:sin valor}")
    private String ymlNewProperty;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de ymlgreeting es: " + ymlGreeting);
        System.out.println("El valor de my.ymlnumber es: " + ymlMyNumber);
        System.out.println("El valor de new.property es: " + ymlNewProperty);
    }
}
