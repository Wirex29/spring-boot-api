package com.nonpaidintern.cleanarchitectureapi.application.common.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DataMapper {

    <E> void save(E entity);

    <T extends Dto> Page<T> getPaginatedList(Pageable pageable);
}
