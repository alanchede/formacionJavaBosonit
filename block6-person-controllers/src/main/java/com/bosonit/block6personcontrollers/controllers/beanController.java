package com.bosonit.block6personcontrollers.controllers;

import com.bosonit.block6personcontrollers.classes.Person;
import com.bosonit.block6personcontrollers.services.BeanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class beanController {

    @GetMapping(value = "/controller/bean/{bean}")
        public Person getBean(@PathVariable String bean){
        BeanServices beanServices = new BeanServices();
        return beanServices.returnBean(bean);
    }




}
