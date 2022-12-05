package com.bosonit.block7crudvalidation.Persona.infrastructure.controllers;

import com.bosonit.block7crudvalidation.Persona.application.services.PersonService;
import com.bosonit.block7crudvalidation.Persona.domain.models.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdatePerson {
    @Autowired
    PersonService personService;

    @PutMapping("person/{id}")
    public String updatePerson(@PathVariable int id, @RequestBody PersonModel person) {
        return personService.updatePerson(id, person);
    }
}
