package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.DataMapper;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index.RecruitIndexDto;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Recruitment;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.RecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Qualifier("recruitmentMapper")
public class RecruitmentDataMapper implements DataMapper {

    private final RecruitmentRepository repository;

    private final Function<Recruitment, RecruitIndexDto> mapper = recruitment -> new RecruitIndexDto(recruitment.getId(),
            recruitment.getImage_uri(),
            recruitment.getTitle(),
            recruitment.getSlug_title(),
            recruitment.getExpired_at(),
            recruitment.getWork_type(),
            recruitment.getWork_location(),
            recruitment.getTags());

    @Autowired
    public RecruitmentDataMapper(RecruitmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public <E> void save(E entity) {
        repository.save((Recruitment) entity);
    }

    @Override
    public Page<?> getPaginatedList(Pageable pageable) {

        Page<Recruitment> paginatedRecruitmentList = repository.findAll(pageable);

        return paginatedRecruitmentList.map(mapper);
    }
}
