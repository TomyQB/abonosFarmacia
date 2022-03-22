package com.farmacia.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ABONO_HISTORY")
public class AbonoHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String albaran;
    private String codigo;
    private String nombre;
    private String fecha;
    private int unidades;
    private byte[] archivo;
}
