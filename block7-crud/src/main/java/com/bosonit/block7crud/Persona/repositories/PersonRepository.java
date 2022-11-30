package com.bosonit.block7crud.Persona.repositories;

import com.bosonit.block7crud.Persona.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel,Integer> {
    List<PersonModel> getByName(String name);
}