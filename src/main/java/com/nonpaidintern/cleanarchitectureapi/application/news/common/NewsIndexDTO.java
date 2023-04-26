package com.nonpaidintern.cleanarchitectureapi.application.news.common;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public record NewsIndexDTO(String title, String slugTitle, String imageUri, String poster, LocalDate postedOn) {
}
