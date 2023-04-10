package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;

import java.util.UUID;

public class RecruitmentInfo extends BaseEntity {

    private String content;

    public RecruitmentInfo(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
