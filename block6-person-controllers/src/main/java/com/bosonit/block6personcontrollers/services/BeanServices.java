package com.bosonit.block6personcontrollers.services;

import com.bosonit.block6personcontrollers.classes.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class BeanServices {

    @Bean
    public Person bean1() {
        return new Person("Bean1", 1234, "bean1");
    }

    @Bean
    public Person bean2() {
        return new Person("Bean2", 1234, "bean2");
    }

    @Bean
    public Person bean3() {
        return new Person("Bean3", 1234, "bean3");
    }

    public Person returnBean(String person) {
        return switch (person) {
            case "bean1" -> bean1();
            case "bean2" -> bean2();
            case "bean3" -> bean3();
            default -> new Person("", 0, "");
        };
    }
}
