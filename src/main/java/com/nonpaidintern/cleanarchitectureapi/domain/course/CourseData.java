package com.nonpaidintern.cleanarchitectureapi.domain.course;

import com.fasterxml.jackson.databind.JsonNode;

public class CourseData {

    private JsonNode body;

    public CourseData(JsonNode body) {
        this.body = body;
    }

    public JsonNode getBody() {
        return body;
    }

    public void setBody(JsonNode body) {
        this.body = body;
    }
}
