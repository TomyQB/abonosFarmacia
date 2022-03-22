package com.farmacia.back.service;

import java.util.List;

import com.farmacia.back.mapper.AbonoHistoryMapper;
import com.farmacia.back.model.Abono;
import com.farmacia.back.model.dto.AbonoDTO;
import com.farmacia.back.repository.AbonoHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonoHistoryService {
    
    @Autowired
    private AbonoHistoryRepository abonoHistoryRepository;

    @Autowired
    private AbonoHistoryMapper abonoHistoryMapper;

    public List<AbonoDTO> getAllAbonosHistory() {
        return abonoHistoryMapper.entitiesToDtos(abonoHistoryRepository.findAll());        
    }

    public void abonoToHistory(Abono abono) {
        abonoHistoryRepository.save(abonoHistoryMapper.AbonoToAbonoHistory(abono));
    }
    
    public byte[] getArchivoByIdAbonoHistory(Long id) {
        return abonoHistoryRepository.getById(id).getArchivo();
    }

}
