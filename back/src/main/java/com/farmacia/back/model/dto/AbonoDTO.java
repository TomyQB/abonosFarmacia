package com.farmacia.back.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonoDTO {
    
    private long id;
    private String albaran;
    private String codigo;
    private String nombre;
    private String fecha;
    private int unidades;
    private byte[] archivo;
    
}
