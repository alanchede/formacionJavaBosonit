package com.bosonit.block6simplecontrollers.PersonControllers;

import com.bosonit.block6simplecontrollers.PersonClasses.People;
import com.bosonit.block6simplecontrollers.PersonClasses.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class PersonController {

    @Autowired
    private People people;

   @GetMapping(value = "/user/{name}")
    public String getUser(@PathVariable String name){
       return people.searchPerson(name);
   }


   @PostMapping(value = "/useradd")
    public Person addUser(@RequestBody Person person){
       people.addPerson(person);
       person.setAge(person.getAge() + 1);
       return person;
   }



}
