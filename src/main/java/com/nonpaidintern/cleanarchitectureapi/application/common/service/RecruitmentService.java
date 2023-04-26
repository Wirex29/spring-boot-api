package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.CreateRecruitmentDTO;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.IndexQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface RecruitmentService {

    void save(CreateRecruitmentDTO dto);

    Page<IndexQueryDTO> fetchPaginated(Pageable pageable);
//
    Page<IndexQueryDTO> fetchPaginated(Pageable pageable, String key, String technology, String position, String workLocation);
}
