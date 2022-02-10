package com.farmacia.back.repository;

import com.farmacia.back.model.Abono;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonoRepository extends JpaRepository<Abono, Long> {

    Abono findByCodigo(String codigo);

    byte[] findArchivoById(Long id);
    
}
