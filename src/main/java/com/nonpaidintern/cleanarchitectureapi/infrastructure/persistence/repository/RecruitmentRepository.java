package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Recruitment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, UUID> {
    Page<Recruitment> findByTitleLikeIgnoreCaseAndSkillRequirements_NameIgnoreCaseAndPositionIgnoreCaseAndWorkLocationIgnoreCase(
            @Nullable String title,
            @Nullable String name,
            @Nullable String position,
            @Nullable String workLocation,
            Pageable pageable);


}
