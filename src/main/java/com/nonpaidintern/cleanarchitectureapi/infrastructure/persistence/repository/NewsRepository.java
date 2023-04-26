package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {
}
