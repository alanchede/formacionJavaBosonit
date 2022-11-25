package com.bosonit.block6personcontrollers.controllers;

import com.bosonit.block6personcontrollers.classes.City;
import com.bosonit.block6personcontrollers.classes.Person;
import com.bosonit.block6personcontrollers.services.CityServices;
import com.bosonit.block6personcontrollers.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/controller1")
public class controller1 {

    @Autowired
    private PersonServices personServices;
    @GetMapping(value = "/addPerson")
    public Person addPerson(String name, int age, String city){
        return personServices.createPerson(name,age,city);
    }
    @Autowired
    private CityServices cityServices;
    @PostMapping(value = "/addCity")
    public City addCity(@RequestBody City city){
        cityServices.addCity(city);
        return city;
    }


}
