package com.farmacia.back.mapper;


import java.util.ArrayList;
import java.util.List;

import com.farmacia.back.model.Abono;
import com.farmacia.back.model.dto.AbonoDTO;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

// @Mapper(componentModel = "spring")
@Service
public class AbonoMapper /*extends IMapper<Abono, AbonoDTO>*/ {

    public Abono dtoToEntity(AbonoDTO dto) {
        Abono abono = new Abono();

        abono.setAlbaran(dto.getAlbaran());
        abono.setArchivo(dto.getArchivo());
        abono.setCodigo(dto.getCodigo());
        abono.setFecha(dto.getFecha());
        abono.setNombre(dto.getNombre());
        abono.setUnidades(dto.getUnidades());

        return abono;
    }
    // AbonoDTO entityToDto(Abono entity);

    // List<Abono> dtosToEntities(List<AbonoDTO> dtos);
    public List<AbonoDTO> entitiesToDtos(List<Abono> entities) {
        List<AbonoDTO> dtos = new ArrayList<>();

        for (Abono entity : entities) {
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
}
