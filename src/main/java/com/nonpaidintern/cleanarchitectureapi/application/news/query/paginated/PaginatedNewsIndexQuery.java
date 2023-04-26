package com.nonpaidintern.cleanarchitectureapi.application.news.query.paginated;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.NewsService;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsIndexDTO;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedNewsIndexQuery implements Request<Page<NewsIndexDTO>> {

    private String key;

    @Value("1")
    private int page_number;
    @Value("6")
    private int per_page;

    @Service
    static class PaginatedNewsIndexQueryHandler implements RequestHandler<PaginatedNewsIndexQuery, Page<NewsIndexDTO>> {

        private final NewsService newsService;

        @Autowired
        PaginatedNewsIndexQueryHandler(NewsService newsService) {
            this.newsService = newsService;
        }

        @Override
        public Page<NewsIndexDTO> handle(PaginatedNewsIndexQuery query) {


            int page = query.page_number > 0 ? query.page_number - 1 : 0;
            int perPage = query.per_page > 0 ? query.per_page : 6;

            PageRequest pageRequest = PageRequest.of(page, perPage);

            if (query.key != null && !query.key.isBlank()) {
                return newsService.fetchAllBy(pageRequest, query.key);
            } else {
                return newsService.fetchAll(pageRequest);
            }
        }
    }
}
