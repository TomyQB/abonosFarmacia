package com.farmacia.back.mapper;

import java.util.List;

public interface IMapper<E, D> {

    E dtoToEntity(D dto);
    D entityToDto(E entity);

    List<E> dtosToEntities(List<D> dtos);
    List<D> entitiesToDtos(List<E> entities);
}
