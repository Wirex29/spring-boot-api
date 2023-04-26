package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.RecruitmentService;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.CreateRecruitmentDTO;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.IndexQueryDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.BenefitId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.TechnologyId;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.*;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.BenefitRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.RecruitmentRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.TechnologyRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RecruitmentServiceImp implements RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserRepository userRepository;
    private final TechnologyRepository technologyRepository;
    private final BenefitRepository benefitRepository;

    private final Function<Recruitment, IndexQueryDTO> mapDto = recruitment -> new IndexQueryDTO(
            recruitment.getImageUri(),
            recruitment.getTitle(),
            recruitment.getSlugTitle(),
            recruitment.getExpiredAt(),
            recruitment.getWorkType(),
            recruitment.getWorkLocation(),
            recruitment.getTags());

    public RecruitmentServiceImp(RecruitmentRepository recruitmentRepository, UserRepository userRepository,
                                 TechnologyRepository technologyRepository, BenefitRepository benefitRepository)
    {
        this.recruitmentRepository = recruitmentRepository;
        this.userRepository = userRepository;
        this.technologyRepository = technologyRepository;
        this.benefitRepository = benefitRepository;
    }

    @Override
    public void save(CreateRecruitmentDTO dto) {

        User poster = userRepository.findById(dto.recruitment().getPoster().value()).orElseThrow();

        RecruitmentBody body = RecruitmentBody.builder().body(dto.recruitment().getBody().getContent().toString()).build();

        Set<Technology> technologySet = new HashSet<>(technologyRepository.findAllById(dto.recruitment()
                .getSkillsRequirement()
                .stream()
                .map(TechnologyId::value)
                .collect(
                        Collectors.toSet())));

        Set<Benefit> benefitSet = new HashSet<>(benefitRepository.findAllById(dto.recruitment()
                .getBenefits()
                .stream()
                .map(
                        BenefitId::value)
                .collect(Collectors.toSet())));

        Recruitment recruitment = Recruitment.builder()
                .title(dto.recruitment().getTitle())
                .imageUri(dto.recruitment().getImgUri())
                .slugTitle(dto.recruitment().getPrettyUrl())
                .status(dto.recruitment().getStatus().toString())
                .expiredAt(dto.recruitment().getExpireAt())
                .createdAt(dto.recruitment().getCreatedAt())
                .position(dto.recruitment().getPosition())
                .workType(dto.recruitment().getWorkType())
                .incomeProposal(dto.recruitment().getIncomeProposal())
                .body(body)
                .poster(poster)
                .benefits(benefitSet)
                .skillRequirements(technologySet)
                .build();

        recruitmentRepository.save(recruitment);
    }

    @Override
    public Page<IndexQueryDTO> fetchPaginated(Pageable pageable) {

        Page<Recruitment> recruitments = recruitmentRepository.findAll(pageable);

        return recruitments.map(mapDto);
    }

    @Override
    public Page<IndexQueryDTO> fetchPaginated(Pageable pageable,
                                              String key,
                                              String technology,
                                              String position,
                                              String workLocation)
    {
        Page<Recruitment> recruitments = recruitmentRepository.findByTitleLikeIgnoreCaseAndSkillRequirements_NameIgnoreCaseAndPositionIgnoreCaseAndWorkLocationIgnoreCase(key, technology, position, workLocation, pageable);

        return recruitments.map(mapDto);
    }


}
