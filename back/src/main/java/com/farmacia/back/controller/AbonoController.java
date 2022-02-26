package com.farmacia.back.controller;

import java.io.IOException;
import java.util.List;

import com.farmacia.back.model.dto.AbonoDTO;
import com.farmacia.back.service.AbonoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class AbonoController {
    
    @Autowired
    private AbonoService abonoService;


    @GetMapping("/getAllAbonos")
    public List<AbonoDTO> getAllAbonos() {
        return abonoService.getAllAbonos();
    }

    @GetMapping("/getPDF/{id}")
    public byte[] getPDF(@PathVariable("id") Long id) {
        return abonoService.getArchivoByIdAbono(id);
    }
    
    @PostMapping("/uploadPDF")
    public void uploadPDF(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
        abonoService.saveTempPDF(multipartFile);
    }

    @PostMapping("/create")
    public void create(@RequestBody AbonoDTO abonoDTO) throws IOException {
        abonoService.createAbono(abonoDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id) {
        abonoService.deleteAbono(id);
    }
}
