package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {
    Page<News> findByTitleContains(String title, Pageable pageable);

    News findBySlugTitle(String slugTitle);
//    Page<News> findByTitleLike(String title, Pageable pageable);


}
