package com.nonpaidintern.cleanarchitectureapi.application.benefit.query.index;

import java.util.UUID;

public record BenefitIndexDTO(UUID id, String name, String description, String iconUri) {
}
