package com.bosonit.examenJPAcascada.LineaFra;



import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class LineaFra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int IdFra;
    private String ProNomb;
    private Double cantidad;
    private Double precio;

}


