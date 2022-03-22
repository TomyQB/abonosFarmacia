package com.farmacia.back.controller;

import java.util.List;

import com.farmacia.back.model.dto.AbonoDTO;
import com.farmacia.back.service.AbonoHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AbonoHistoryController {
    
    @Autowired
    private AbonoHistoryService abonoHistoryService;
    
       
    @GetMapping("/getAllAbonosHistory")
    public List<AbonoDTO> getAllAbonosHistory() {
        return abonoHistoryService.getAllAbonosHistory();
    }

    @GetMapping("/getPDFHistory/{id}")
    public byte[] getPDF(@PathVariable("id") Long id) {
        return abonoHistoryService.getArchivoByIdAbonoHistory(id);
    } 
}
