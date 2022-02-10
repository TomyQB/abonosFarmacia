package com.farmacia.back.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IMapper<E, D> {
    E dtoToEntity(D dto);
    D entityToDto(E entity);

    List<E> dtosToEntities(List<D> dtos);

    default List<D> entitiesToDto(List<E> entities) {
        return Optional.ofNullable(entities).map(Collection::stream).orElse(Stream.empty()).map(e -> entityToDto(e)).collect(Collectors.toList());
    }
}
