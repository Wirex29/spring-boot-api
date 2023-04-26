package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = @Index(columnList = "id, slugTitle"), name = "recruitment")
@SecondaryTable(name = "recruitment_body", pkJoinColumns = @PrimaryKeyJoinColumn(name = "recruitment_id"))
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slugTitle;

    private String imageUri;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User poster;

    private String workType;

    private String workLocation;

    private BigDecimal incomeProposal;

    private String experienceRequirement;

    @ManyToMany
    @JoinTable(
            name = "recruitment_skill",
            joinColumns =
                @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns =
                @JoinColumn(name = "skill_id")
    )
    private Set<Technology> skillRequirements;

    @ManyToMany
    @JoinTable(
            name = "recruitment_benefit",
            joinColumns =
                    @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns =
                    @JoinColumn(name = "benefit_id")
    )
    private Set<Benefit> benefits;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "body", column = @Column( name = "body", table = "recruitment_body", columnDefinition = "jsonb"))
    })
    private RecruitmentBody body;

    private String position;

    private OffsetDateTime createdAt;

    private OffsetDateTime expiredAt;
    
    private String status;


    public List<String> getTags() {

        List<String> list = new ArrayList<>();

        // EXTRACT WORK TYPE FROM STRING THEN APPEND TO TAGS LIST
        String workType = this.workType;

        int from = workType.indexOf(',');
        int to = workType.indexOf(',', from + 1);

        while (from != to) {

            list.add(workType.substring(from, to));

            from = to;
            to = workType.indexOf(',', from + 1) != -1 ? workType.indexOf(',', from + 1) : workType.length() - 1;
        }

        // ADD SKILL REQUIREMENT INTO TAGS LIST
        for (var skill :
                this.skillRequirements) {
            list.add(skill.getName());
        }

        return list;
    }
}
