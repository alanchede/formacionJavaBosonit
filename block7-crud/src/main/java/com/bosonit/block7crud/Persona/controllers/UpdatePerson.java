package com.bosonit.block7crud.Persona.controllers;

import com.bosonit.block7crud.Persona.models.PersonModel;
import com.bosonit.block7crud.Persona.services.PersonService;
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
