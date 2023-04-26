package com.nonpaidintern.cleanarchitectureapi.application.news.common;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;
import java.util.UUID;

public record NewsDetailDTO(UUID id, String title, String slugTitle, String imageUri, String poster, LocalDate postedOn,
                            JsonNode body) {
}
