package com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index;

import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.DTO;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Recruitment;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Technology;
import org.springframework.data.domain.Page;

public record RecruitIndexDto(Technology technology, Page<Recruitment> recruitments) implements DTO {}
