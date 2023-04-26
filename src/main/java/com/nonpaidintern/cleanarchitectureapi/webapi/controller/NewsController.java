package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsDetailDTO;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.NewsIndexDTO;
import com.nonpaidintern.cleanarchitectureapi.application.news.query.detail.NewsDetailQuery;
import com.nonpaidintern.cleanarchitectureapi.application.news.query.paginated.PaginatedNewsIndexQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    private final Mediator mediator;

    @Autowired
    public NewsController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "/", produces = "application/json")
    public CompletableFuture<ResponseEntity<Page<NewsIndexDTO>>> index(@ModelAttribute PaginatedNewsIndexQuery query) {

        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(query)).thenApply(ResponseEntity::ok);

    }

    @GetMapping(value = "/{slugTitle}", produces = "application/json")
    public CompletableFuture<ResponseEntity<NewsDetailDTO>> detail(@ModelAttribute NewsDetailQuery query) {

        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(query)).thenApply(ResponseEntity::ok);

    }
}
