package com.farmacia.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.farmacia.back.model.Abono;
import com.farmacia.back.model.AbonoHistory;
import com.farmacia.back.model.dto.AbonoDTO;

import org.springframework.stereotype.Service;

@Service
public class AbonoHistoryMapper implements IMapper<AbonoHistory, AbonoDTO>{

    @Override
    public AbonoHistory dtoToEntity(AbonoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AbonoDTO entityToDto(AbonoHistory entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AbonoHistory> dtosToEntities(List<AbonoDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AbonoDTO> entitiesToDtos(List<AbonoHistory> entities) {
        List<AbonoDTO> dtos = new ArrayList<>();

        for (AbonoHistory entity : entities) {
            AbonoDTO dto = new AbonoDTO();
    
            dto.setId(entity.getId());
            dto.setAlbaran(entity.getAlbaran());
            dto.setArchivo(entity.getArchivo());
            dto.setCodigo(entity.getCodigo());
            dto.setFecha(entity.getFecha());
            dto.setNombre(entity.getNombre());
            dto.setUnidades(entity.getUnidades());

            dtos.add(dto);         
        }

        return dtos;
    }
    
    public AbonoHistory AbonoToAbonoHistory(Abono dto) {
        AbonoHistory abonoHistory = new AbonoHistory();

        abonoHistory.setAlbaran(dto.getAlbaran());
        abonoHistory.setArchivo(dto.getArchivo());
        abonoHistory.setCodigo(dto.getCodigo());
        abonoHistory.setFecha(dto.getFecha());
        abonoHistory.setNombre(dto.getNombre());
        abonoHistory.setUnidades(dto.getUnidades());

        return abonoHistory;
    }
    
}
