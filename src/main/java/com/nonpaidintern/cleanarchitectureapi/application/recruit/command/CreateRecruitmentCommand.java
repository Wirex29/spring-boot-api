package com.nonpaidintern.cleanarchitectureapi.application.recruit.command;

import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Benefit;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.RecruitmentInfo;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Skill;
import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecruitmentCommand implements Request {

    private String img_uri;
    private String work_type;
    private String title;
    private String slug_title;
    private String poster;
    private String work_location;
    private BigDecimal income_proposal;
    private String experience_requirement;
    private Set<Skill> skill_requirement;
    private String position;
    private Set<Benefit> benefits;
    private RecruitmentInfo content;
    private OffsetDateTime created_at;
    private OffsetDateTime expire_at;

}
