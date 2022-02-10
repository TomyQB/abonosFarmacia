package com.farmacia.back.mapper;

import java.util.List;

import com.farmacia.back.model.Abono;
import com.farmacia.back.model.AbonoDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbonoMapper /*implements IMapper<Abono, AbonoDTO>*/ {
    
    Abono dtoToEntity(AbonoDTO dto);
    AbonoDTO entityToDto(Abono entity);

    List<Abono> dtosToEntities(List<AbonoDTO> dtos);
    List<AbonoDTO> entitiesToDtos(List<Abono> dtos);

}
