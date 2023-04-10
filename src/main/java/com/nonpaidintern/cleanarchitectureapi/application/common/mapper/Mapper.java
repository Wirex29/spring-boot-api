package com.nonpaidintern.cleanarchitectureapi.application.common.mapper;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;

public interface Mapper<D, E extends BaseEntity> {

    E dtoToEntity(D dto);

    D entityToDto(E entity);
}
