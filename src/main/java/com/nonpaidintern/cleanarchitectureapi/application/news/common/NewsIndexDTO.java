package com.nonpaidintern.cleanarchitectureapi.application.news.common;

import java.time.LocalDate;
import java.util.UUID;

public record NewsIndexDTO(UUID id, String title, String slugTitle, String imageUri, String poster, LocalDate postedOn) {
}
