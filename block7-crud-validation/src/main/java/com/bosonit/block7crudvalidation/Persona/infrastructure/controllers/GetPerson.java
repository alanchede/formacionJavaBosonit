package com.bosonit.block7crudvalidation.Persona.infrastructure.controllers;

import com.bosonit.block7crudvalidation.Persona.application.services.PersonService;
import com.bosonit.block7crudvalidation.Persona.domain.models.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GetPerson {
    @Autowired
    PersonService personService;

    @GetMapping("person")
    public List<PersonModel> getPersonList(){
        return personService.getPersonList();
    }
    @GetMapping("person/name/{name}")
    public List<PersonModel> getPersonListByName(@PathVariable String name){
        return personService.getPersonListByName(name);
    }
    @GetMapping("person/{id}")
    public String getPerson(@PathVariable int id) {
        return "Person with id " + id + " is " + personService.getPerson(id).getName();
    }
}
