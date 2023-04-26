package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.TechnologyService;
import com.nonpaidintern.cleanarchitectureapi.application.technology.common.CreateTechnologyEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.technology.query.index.TechnologyIndexDTO;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Technology;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.TechnologyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TechnologyServiceImp implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    private final Function<Technology, TechnologyIndexDTO> mapper = technology -> new TechnologyIndexDTO(technology.getId(), technology.getName());

    public TechnologyServiceImp(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public void save(CreateTechnologyEntryDTO dto) {
        Technology technology = Technology.builder()
                .name(dto.technology().getName())
                .build();
    }

    @Override
    public List<TechnologyIndexDTO> fetchAll() {

        return technologyRepository.findAll().stream().map(mapper).collect(Collectors.toList());
    }
}
