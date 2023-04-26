package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.NewsService;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.CreateNewsPostDTO;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsDetailDTO;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsIndexDTO;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.News;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.NewsBody;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.User;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.NewsRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.UserRepository;
import io.hypersistence.utils.hibernate.type.json.internal.JacksonUtil;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NewsServiceImp implements NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    private final Function<News, NewsIndexDTO> indexMapper = news -> new NewsIndexDTO(
            news.getId(),
            news.getTitle(),
            news.getSlugTitle(),
            news.getImageUri(),
            news.getPoster().getUsername(),
            news.getCreatedAt().toLocalDate()
    );

    public NewsServiceImp(NewsRepository newsRepository, UserRepository userRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(CreateNewsPostDTO dto) {
        User user = userRepository.findById(dto.news().getPoster().value()).orElseThrow();

        News news = News.builder()
                .title(dto.news().getTitle())
                .slugTitle(dto.news().getPrettyUrl())
                .imageUri(dto.news().getImageUri())
                .createdAt(dto.news().getCreatedAt())
                .status(dto.news().getStatus().toString())
                .poster(user)
                .body(new NewsBody(dto.news().getBody().getContent()))
                .build();

        newsRepository.save(news);
    }

    @Override
    public Page<NewsIndexDTO> fetchAll(Pageable pageable) {

        return newsRepository.findAll(pageable).map(indexMapper);
    }

    @Override
    public Page<NewsIndexDTO> fetchAllBy(Pageable pageable, String key) {
        return newsRepository.findByTitleContains(key, pageable).map(indexMapper);
    }

    @Override
    public NewsDetailDTO fetchBySlugTitle(String title) {
        News news = newsRepository.findBySlugTitle(title);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.valueToTree(news.getBody().getContent());

        return new NewsDetailDTO(news.getId(),
                news.getTitle(),
                news.getSlugTitle(),
                news.getImageUri(),
                news.getPoster().getUsername(),
                news.getCreatedAt().toLocalDate(),
                json
        );
    }
}
