package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.news.common.CreateNewsPostDTO;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsIndexDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface NewsService {

    void save(CreateNewsPostDTO dto);

    Page<NewsIndexDTO> fetchAll(Pageable pageable);
}
