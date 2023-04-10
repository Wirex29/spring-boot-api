package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

public class Recruitment extends BaseEntity {

    private String img_uri;
    private String work_type;
    private String title;
    private String poster;
    private String work_location;
    private BigDecimal income_proposal;
    private String experience_requirement;
    private String skill_requirement;
    private String position;
    private Set<Benefit> benefits;
    private RecruitmentInfo content;
    private OffsetDateTime created_at;
    private OffsetDateTime expire_at;

    public Recruitment(UUID id,
                       String img,
                       String work_type,
                       String title,
                       String poster,
                       String work_location,
                       BigDecimal income_proposal,
                       String experience_requirement,
                       String skill_requirement,
                       String position,
                       Set<Benefit> benefits,
                       RecruitmentInfo content,
                       OffsetDateTime created_at,
                       OffsetDateTime expire_at)
    {
        this.id = id;
        this.img_uri = img;
        this.work_type = work_type;
        this.title = title;
        this.poster = poster;
        this.work_location = work_location;
        this.income_proposal = income_proposal;
        this.experience_requirement = experience_requirement;
        this.skill_requirement = skill_requirement;
        this.position = position;
        this.benefits = benefits;
        this.content = content;
        this.created_at = created_at;
        this.expire_at = expire_at;
    }

    public String getImg_uri() {
        return img_uri;
    }

    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }

    public BigDecimal getIncome_proposal() {
        return income_proposal;
    }

    public void setIncome_proposal(BigDecimal income_proposal) {
        this.income_proposal = income_proposal;
    }

    public String getExperience_requirement() {
        return experience_requirement;
    }

    public void setExperience_requirement(String experience_requirement) {
        this.experience_requirement = experience_requirement;
    }

    public String getSkill_requirement() {
        return skill_requirement;
    }

    public void setSkill_requirement(String skill_requirement) {
        this.skill_requirement = skill_requirement;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Benefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(Set<Benefit> benefits) {
        this.benefits = benefits;
    }

    public RecruitmentInfo getContent() {
        return content;
    }

    public void setContent(RecruitmentInfo content) {
        this.content = content;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public OffsetDateTime getExpire_at() {
        return expire_at;
    }

    public void setExpire_at(OffsetDateTime expire_at) {
        this.expire_at = expire_at;
    }
}
