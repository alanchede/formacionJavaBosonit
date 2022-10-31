package com.example.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SegundaClase{
 @Bean
   CommandLineRunner ejecutarSegundaClase()
   {
      return p ->
      {
    	     System.out.println("Hola desde la segunda clase");
      };
}

}
