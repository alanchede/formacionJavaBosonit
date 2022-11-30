package com.bosonit.block7crud.Persona.controllers;

import com.bosonit.block7crud.Persona.models.PersonModel;
import com.bosonit.block7crud.Persona.services.PersonService;
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
