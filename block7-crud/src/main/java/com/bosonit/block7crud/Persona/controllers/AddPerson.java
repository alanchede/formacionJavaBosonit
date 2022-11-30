package com.bosonit.block7crud.Persona.controllers;

import com.bosonit.block7crud.Persona.models.PersonModel;
import com.bosonit.block7crud.Persona.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPerson {

    @Autowired
    PersonService personService;

    @PostMapping("person")
    public String addPerson(@RequestBody PersonModel person) {
        personService.addPerson(person);
        return "Person added: " + person.getName();
    }
}
