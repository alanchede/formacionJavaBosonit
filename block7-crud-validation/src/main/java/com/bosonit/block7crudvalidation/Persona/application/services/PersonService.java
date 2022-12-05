package com.bosonit.block7crudvalidation.Persona.application.services;

import com.bosonit.block7crudvalidation.Persona.domain.models.PersonModel;
import com.bosonit.block7crudvalidation.Persona.infrastructure.DTO.PersonInputDTO;
import com.bosonit.block7crudvalidation.Persona.infrastructure.DTO.PersonOutputDTO;
import com.bosonit.block7crudvalidation.exceptions.ResourceNotFoundException;
import com.bosonit.block7crudvalidation.Persona.infrastructure.repositories.PersonRepository;
import com.bosonit.block7crudvalidation.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public static PersonModel inputPersonModel(PersonInputDTO person) {
        PersonModel personModel = new PersonModel();
        personModel.setId(person.getId());
        personModel.setUser(person.getUser());
        personModel.setPassword(person.getPassword());
        personModel.setName(person.getName());
        personModel.setSurname(person.getSurname());
        personModel.setCompany_email(person.getCompany_email());
        personModel.setPersonal_email(person.getPersonal_email());
        personModel.setCity(person.getCity());
        personModel.setImage_url(person.getImage_url());
        personModel.setActive(person.getActive());
        personModel.setCreated_date(person.getCreated_date());
        personModel.setTermination_date(person.getTermination_date());
        return personModel;
    }

    public PersonOutputDTO addPerson(PersonInputDTO person) throws Exception {
        personValidator(person);
        PersonModel p = inputPersonModel(person);
        personRepository.save(p);
        return p.entityToDTO();
    }

    public PersonOutputDTO getPerson(int id) {
        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));
        return personRepository.getReferenceById(id).entityToDTO();
    }

    public List<PersonOutputDTO> getPersonList() {
        return personRepository.findAll().stream().map(PersonModel::entityToDTO).toList();
    }

    public List<PersonOutputDTO> getPersonListByName(String name) {
        return personRepository.getByName(name).stream().map(PersonModel::entityToDTO).toList();
    }

    @Modifying
    public String updatePerson(int id, PersonInputDTO personDetails) {

        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));

        person.setName(personDetails.getName());
        person.setCity(personDetails.getCity());

        PersonModel updatedPerson = personRepository.save(person);
        return "Person updated";
    }

    public String deletePerson(int id) {
        PersonModel person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id :" + id + " does not exist."));
        personRepository.delete(person);
        return "Person deleted";
    }

    public void personValidator(PersonInputDTO personInputDTO) throws UnprocessableEntityException {
        if (personInputDTO.getName() == null) {
            throw new UnprocessableEntityException("Name can't be null");
        }
        if (personInputDTO.getUser().length() > 10) {
            throw new UnprocessableEntityException("User can't have more than 10 characters");
        }
        if (personInputDTO.getUser().length() < 6) {
            throw new UnprocessableEntityException("User can't have les than 6 characters");
        }

    }
}
