package com.nonpaidintern.cleanarchitectureapi.application.news.command.create;

import com.fasterxml.jackson.databind.JsonNode;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.DateTimeProvider;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.NewsService;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.CreateNewsPostDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.news.News;
import com.nonpaidintern.cleanarchitectureapi.domain.news.NewsBody;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewsPostCommand implements Command {
    private String title;
    private UserId poster;
    private String image_uri;
    private JsonNode body;
    private Status status;

    @Component
    static class CreateNewsPostCommandHandler implements CommandHandler<CreateNewsPostCommand>{

        private final NewsService newsService;
        private final DateTimeProvider dateTimeProvider;

        @Autowired
        CreateNewsPostCommandHandler(NewsService newsService, DateTimeProvider dateTimeProvider) {
            this.newsService = newsService;
            this.dateTimeProvider = dateTimeProvider;
        }

        @Override
        public void handle(CreateNewsPostCommand command) {
            News news = new News();
            news.setBody(new NewsBody(command.body));
            news.setTitle(command.title);
            news.setStatus(command.status);
            news.setPoster(command.poster);
            news.setImageUri(command.image_uri);
            news.setCreatedAt(dateTimeProvider.timeNow());

            newsService.save(new CreateNewsPostDTO(news));
        }
    }
}
