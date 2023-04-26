package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.benefit.common.CreateBenefitEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.benefit.query.index.BenefitIndexDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BenefitService {

    void save(CreateBenefitEntryDTO dto);

    List<BenefitIndexDTO> fetchAll();
}
