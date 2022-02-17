package com.farmacia.back.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbonoDTO {
    
    private long id;
    private String albaran;
    private String codigo;
    private String nombre;
    private String fecha;
    private int unidades;
    private byte[] archivo;
    
}
