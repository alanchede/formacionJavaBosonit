package com.bosonit.block7crudvalidation.Persona.domain.models;

import com.bosonit.block7crudvalidation.Persona.infrastructure.DTO.PersonOutputDTO;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private String city;
    @Column(nullable = false, length = 10)
    private String user;
    @Column(nullable = false)
    private String password;
    @Column
    private String surname;
    @Column(nullable = false)
    private String company_email;
    @Column(nullable = false)
    private String personal_email;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    private Date created_date;
    @Column
    private String image_url;
    @Column
    private Date termination_date;

    public PersonOutputDTO entityToDTO() {
        PersonOutputDTO p = new PersonOutputDTO();
        p.setId(this.id);
        p.setUser(this.user);
        p.setName(this.name);
        p.setSurname(this.surname);
        p.setCompany_email(this.company_email);
        p.setPersonal_email(this.personal_email);
        p.setCity(this.city);
        p.setImage_url(this.image_url);
        p.setActive(this.active);
        p.setCreated_date(this.created_date);
        p.setTermination_date(this.termination_date);
        return p;
    }
}

