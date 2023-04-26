package com.nonpaidintern.cleanarchitectureapi.domain.news;

import com.fasterxml.jackson.databind.JsonNode;

public class NewsBody {
    private JsonNode content;

    public NewsBody(JsonNode body) {
        this.content = body;
    }

    public JsonNode getContent() {
        return content;
    }
}
