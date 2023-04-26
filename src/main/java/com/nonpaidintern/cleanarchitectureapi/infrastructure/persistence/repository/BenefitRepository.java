package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BenefitRepository extends JpaRepository<Benefit, UUID> {
}
