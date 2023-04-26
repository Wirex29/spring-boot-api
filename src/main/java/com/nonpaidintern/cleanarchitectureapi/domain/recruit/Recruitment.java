package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.BenefitId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.RecruitmentId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.TechnologyId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.OffsetDateTime;
import java.util.Set;

public class Recruitment extends BaseEntity<RecruitmentId> {

    private String imgUri;
    private String workType;
    private String title;

    //    private String slug_title;
    private UserId poster;
    private String workLocation;
    private BigDecimal incomeProposal;
    private String experienceRequirement;
    private Set<TechnologyId> skillsRequirement;
    private String position;
    private Set<BenefitId> benefits;
    private RecruitmentInfo body;
    private OffsetDateTime createdAt;
    private OffsetDateTime expireAt;
    private Status status;

    public Recruitment(){};

    public Recruitment(RecruitmentId id,
                       String imgUri,
                       String workType,
                       String title,
                       UserId poster,
                       String workLocation,
                       BigDecimal incomeProposal,
                       String experienceRequirement,
                       Set<TechnologyId> skillsRequirement,
                       String position,
                       Set<BenefitId> benefits,
                       RecruitmentInfo body,
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
        this.body = body;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
        this.status = status;
    }

    public String getPrettyUrl() {
        return Normalizer.normalize(this.title.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{Alnum}]+", "-");
    }

    public String getImgUri() {
        return imgUri;
    }

    public String getWorkType() {
        return workType;
    }

    public String getTitle() {
        return title;
    }

    public UserId getPoster() {
        return poster;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public BigDecimal getIncomeProposal() {
        return incomeProposal;
    }

    public String getExperienceRequirement() {
        return experienceRequirement;
    }

    public Set<TechnologyId> getSkillsRequirement() {
        return skillsRequirement;
    }

    public String getPosition() {
        return position;
    }

    public Set<BenefitId> getBenefits() {
        return benefits;
    }

    public RecruitmentInfo getBody() {
        return body;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getExpireAt() {
        return expireAt;
    }

    public Status getStatus() {
        return status;
    }
}
