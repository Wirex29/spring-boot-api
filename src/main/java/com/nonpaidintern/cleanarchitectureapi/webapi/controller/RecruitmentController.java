package com.nonpaidintern.cleanarchitectureapi.webapi.controller;


import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.IndexQueryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index.IndexQuery;
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
@RequestMapping("/api/v1/recruitment")
public class RecruitmentController {

    private final Mediator mediator;

    @Autowired
    public RecruitmentController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "",
                produces = {"application/json"}
    )
    public CompletableFuture<ResponseEntity<Page<IndexQueryDTO>>> index(@ModelAttribute IndexQuery query) {

        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(query)).thenApply(ResponseEntity::ok);
    }


}
