package com.nonpaidintern.cleanarchitectureapi.application.news.query.detail;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.NewsService;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsDetailDTO;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDetailQuery implements Request<NewsDetailDTO> {

    private String slugTitle;

    @Service
    static class NewsDetailQueryHandler implements RequestHandler<NewsDetailQuery, NewsDetailDTO> {

        private final NewsService newsService;

        @Autowired
        NewsDetailQueryHandler(NewsService newsService) {
            this.newsService = newsService;
        }

        @Override
        public NewsDetailDTO handle(NewsDetailQuery query) {

            var thing = newsService.fetchBySlugTitle(query.slugTitle);

            return thing;
        }
    }

}
