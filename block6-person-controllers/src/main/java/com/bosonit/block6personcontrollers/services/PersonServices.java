package com.bosonit.block6personcontrollers.services;

import com.bosonit.block6personcontrollers.classes.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    private Person person;
    public Person createPerson(String name, int age, String city) {
        person = new Person(name, age, city);
        return person;
    }

    public Person getPerson(){
        return person;
    }
}
