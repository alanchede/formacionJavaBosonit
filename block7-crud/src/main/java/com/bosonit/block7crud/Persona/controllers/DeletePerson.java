package com.bosonit.block7crud.Persona.controllers;

import com.bosonit.block7crud.Persona.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePerson {
    @Autowired
    PersonService personService;

    @DeleteMapping("person/{id}")
    public String updatePerson(@PathVariable int id){
        return personService.deletePerson(id);
    }
}
