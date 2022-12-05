package com.bosonit.block7crudvalidation.Persona.infrastructure.DTO;

import lombok.Data;


import java.util.Date;

@Data
public class PersonInputDTO {
    private int id;
    private String name;
    private String city;
    private String user;
    private String password;
    private String surname;
    private String company_email;
    private String personal_email;
    private Boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

}
