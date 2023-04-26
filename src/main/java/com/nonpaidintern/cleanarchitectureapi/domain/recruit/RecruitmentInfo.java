package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.UUID;

public class RecruitmentInfo {

    private JSONObject content;

    public RecruitmentInfo(JSONObject content) {
        this.content = content;
    }

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }
}
