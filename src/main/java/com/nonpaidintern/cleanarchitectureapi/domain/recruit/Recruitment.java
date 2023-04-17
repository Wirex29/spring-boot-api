package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.common.Status;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

public class Recruitment extends BaseEntity {

    private String imgUri;
    private String workType;
    private String title;

//    private String slug_title;
    private String poster;
    private String workLocation;
    private BigDecimal incomeProposal;
    private String experienceRequirement;
    private Set<Skill> skillsRequirement;
    private String position;
    private Set<Benefit> benefits;
    private RecruitmentInfo content;
    private OffsetDateTime createdAt;
    private OffsetDateTime expireAt;
    private Status status;

    public Recruitment(UUID id,
                       String imgUri,
                       String workType,
                       String title,
                       String poster,
                       String workLocation,
                       BigDecimal incomeProposal,
                       String experienceRequirement,
                       Set<Skill> skillsRequirement,
                       String position,
                       Set<Benefit> benefits,
                       RecruitmentInfo content,
                       OffsetDateTime createdAt,
                       OffsetDateTime expireAt,
                       Status status)
    {
        this.id = id;
        this.imgUri = imgUri;
        this.workType = workType;
        this.title = title;
        this.poster = poster;
        this.workLocation = workLocation;
        this.incomeProposal = incomeProposal;
        this.experienceRequirement = experienceRequirement;
        this.skillsRequirement = skillsRequirement;
        this.position = position;
        this.benefits = benefits;
        this.content = content;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
        this.status = status;
    }


}
