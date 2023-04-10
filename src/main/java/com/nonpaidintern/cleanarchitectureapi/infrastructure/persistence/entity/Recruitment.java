package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(indexes = @Index(columnList = "id, slug_title"))
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slug_title;

    private String image_uri;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User poster;

    private String work_type;

    private String work_location;

    private BigDecimal approved_salary;

    private String experience_requirement;

    @ManyToMany
    @JoinTable(
            name = "recruitment_skill",
            joinColumns =
                @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns =
                @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills_requirement;

    private String position;

    private OffsetDateTime created_at;

    private OffsetDateTime expired_at;
    
    private boolean is_expired;


}
