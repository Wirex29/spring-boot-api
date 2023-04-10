package com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class RecruitIndexDto {

    private UUID id;
    private String image_uri;
    private String title;
    private String slug_title;
    private OffsetDateTime expire_at;
    private String work_type;
    private String work_location;
    private List<String> tags;

}
