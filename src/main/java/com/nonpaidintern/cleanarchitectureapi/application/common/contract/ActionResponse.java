package com.nonpaidintern.cleanarchitectureapi.application.common.contract;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;

public record ActionResponse(HttpStatus status, JsonNode data) { }
