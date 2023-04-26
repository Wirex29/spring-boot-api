package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.benefit.common.CreateBenefitEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.benefit.query.index.BenefitIndexDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.BenefitService;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Benefit;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.BenefitRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BenefitServiceImp implements BenefitService {

    private final BenefitRepository benefitRepository;
    private final Function<Benefit, BenefitIndexDTO> mapper = benefit -> new BenefitIndexDTO(benefit.getId(), benefit.getName(),
            benefit.getDescription(),
            benefit.getIcon_uri());

    public BenefitServiceImp(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    @Override
    public void save(CreateBenefitEntryDTO dto) {
        Benefit benefit = Benefit.builder()
                .name(dto.benefit().getName())
                .description(dto.benefit().getDescription())
                .icon_uri(dto.benefit().getIconUri())
                .build();

        benefitRepository.save(benefit);
    }

    @Override
    public List<BenefitIndexDTO> fetchAll() {
        return benefitRepository.findAll().stream().map(mapper).collect(Collectors.toList());
    }
}
