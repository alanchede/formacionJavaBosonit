package com.bosonit.examenJPAcascada.Cliente.Model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
