package com.bosonit.block6simplecontrollers.PersonClasses;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class People {
    private ArrayList<Person> people;

    public People() {
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public String searchPerson(String name){
        for(Person person: people){
           if(person.getName().equals(name)){
               return "Hello there, General " + name;
           }
        }
        return "";
    }
}
