package com.bosonit.examenJPAcascada.CabeceraFra.Model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class CabeceraFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cli_codi;
    private Double ImporteFra;

}

