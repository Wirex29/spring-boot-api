package com.nonpaidintern.cleanarchitectureapi.webapi.controller;


import com.nonpaidintern.cleanarchitectureapi.application.image.command.UploadImageCommand;
import com.nonpaidintern.cleanarchitectureapi.application.image.command.UploadImageDto;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index.RecruitIndexDto;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index.IndexQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/recruit")
public class RecruitmentController {

    private final Mediator mediator;

    @Autowired
    public RecruitmentController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "",
                produces = {"application/json"}
    )
    public CompletableFuture<ResponseEntity<Page<RecruitIndexDto>>> index(@ModelAttribute IndexQuery query) {

        var thing = CompletableFuture.supplyAsync(() -> this.mediator.dispatch(query));

        return thing.thenApply(ResponseEntity::ok);
    }




}
