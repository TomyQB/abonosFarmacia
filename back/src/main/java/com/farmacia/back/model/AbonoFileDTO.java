package com.farmacia.back.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbonoFileDTO {
   
    private long id;
    private String albaran;
    private String codigo;
    private String nombre;
    private String fecha;
    private int unidades;
    private MultipartFile archivo; 
    
}
