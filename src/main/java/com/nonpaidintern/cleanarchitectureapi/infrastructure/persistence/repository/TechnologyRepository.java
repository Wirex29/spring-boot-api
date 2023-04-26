package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnologyRepository extends JpaRepository<Technology, UUID> {
}
