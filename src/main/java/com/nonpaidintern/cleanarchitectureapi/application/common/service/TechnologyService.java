package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.technology.common.CreateTechnologyEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.technology.query.index.TechnologyIndexDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TechnologyService {

    void save(CreateTechnologyEntryDTO dto);

    List<TechnologyIndexDTO> fetchAll();
}
