package com.nonpaidintern.cleanarchitectureapi.application.recruit.common;

import java.time.OffsetDateTime;
import java.util.List;

public record IndexQueryDTO(String imageUri,
                            String title, String slugTitle, OffsetDateTime expirationDate, String workType,
                            String workLocation, List<String> tags) {}
