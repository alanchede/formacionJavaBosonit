package com.bosonit.block6personcontrollers.controllers;

import com.bosonit.block6personcontrollers.classes.City;
import com.bosonit.block6personcontrollers.classes.Person;
import com.bosonit.block6personcontrollers.services.CityServices;
import com.bosonit.block6personcontrollers.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/controller2")
public class controller2 {
    @Autowired
    private PersonServices personServices;

    @GetMapping(value = "/getPerson")
    public Person getPerson() {
        System.out.println(personServices.getPerson());
        int age = personServices.getPerson().getAge();
        personServices.getPerson().setAge(age * 2);
        return personServices.getPerson();
    }
    @Autowired
    private CityServices cityServices;

    @GetMapping(value = "/getCity")
    public ArrayList<City> getCity(){
        return cityServices.getCities();
    }
}
