package com.farmacia.back.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.farmacia.back.mapper.AbonoMapper;
import com.farmacia.back.model.Abono;
import com.farmacia.back.model.dto.AbonoDTO;
import com.farmacia.back.repository.AbonoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AbonoService {
    
    @Autowired
    private AbonoRepository abonoRepository;

    @Autowired
    private AbonoMapper abonoMapper;

    @Autowired
    private AbonoHistoryService abonoHistoryService;

    private byte[] file;

    public List<AbonoDTO> getAllAbonos() {
        return abonoMapper.entitiesToDtos(abonoRepository.findAll());
    }

    public byte[] getArchivoByIdAbono(Long id) {
        return abonoRepository.getById(id).getArchivo();
    }

    public Abono getAbonoByCodigo(String codigo) {
        return abonoRepository.findByCodigo(codigo);
    }

    public void saveTempPDF(MultipartFile file) throws IOException {
        this.file = file.getBytes();
    }

    public void createAbono(AbonoDTO abonoDTO) throws IOException {
        abonoDTO.setArchivo(this.file);
        this.file = null;
        abonoRepository.save(abonoMapper.dtoToEntity(abonoDTO));
    }

    public void deleteAbono(Long id) {
        Abono abono = abonoRepository.getById(id);
        abonoHistoryService.abonoToHistory(abono);
        abonoRepository.delete(abono);
    }
}
