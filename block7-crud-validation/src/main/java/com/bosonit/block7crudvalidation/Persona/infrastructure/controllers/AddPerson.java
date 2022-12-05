package com.bosonit.block7crudvalidation.Persona.infrastructure.controllers;

import com.bosonit.block7crudvalidation.Persona.application.services.PersonService;
import com.bosonit.block7crudvalidation.Persona.infrastructure.DTO.PersonInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPerson {

    @Autowired
    PersonService personService;

    @PostMapping("person")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception {
        personService.addPerson(person);
        return "Person added: " + person.getName();
    }
}
