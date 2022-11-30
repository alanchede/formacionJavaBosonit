package com.bosonit.block7crud.Persona.services;

import com.bosonit.block7crud.Persona.exceptions.ResourceNotFoundException;
import com.bosonit.block7crud.Persona.models.PersonModel;
import com.bosonit.block7crud.Persona.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;


    public PersonModel addPerson(PersonModel person) {
        personRepository.save(person);
        return person;
    }

    public PersonModel getPerson(int id) {
        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));
        return personRepository.getReferenceById(id);
    }

    public List<PersonModel> getPersonList(){
        return personRepository.findAll();
    }
    public List<PersonModel> getPersonListByName(String name){
        return personRepository.getByName(name);
    }

    @Modifying
    public String updatePerson(int id, PersonModel personDetails) {

        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));

        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        person.setCity(personDetails.getCity());

        PersonModel updatedPerson = personRepository.save(person);
        return "Person updated";
    }
    public String deletePerson(int id){
        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));
        personRepository.delete(person);
        return "Person deleted";
    }
}
