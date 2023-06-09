package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentBody {

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private String body;

}
