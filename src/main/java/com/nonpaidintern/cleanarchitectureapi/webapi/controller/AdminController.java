package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.nonpaidintern.cleanarchitectureapi.application.recruit.command.create.CreateRecruitmentCommand;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.CreateRecruitmentResult;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final Mediator mediator;

    @Autowired
    public AdminController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping(value = "/create-new-recruitment", consumes = "application/json")
    public CompletableFuture<ResponseEntity<CreateRecruitmentResult>> createRecruitmentPost(@ModelAttribute
                                                                                            CreateRecruitmentCommand command) {

//        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(command)).thenApply(ResponseEntity::ok);
        try {
            this.mediator.dispatch(command);

            return CompletableFuture.completedFuture(ResponseEntity.ok().build());

        } catch(Exception e) {
            return CompletableFuture.completedFuture( ResponseEntity.badRequest().body(new CreateRecruitmentResult(400, e.getMessage())));
        }

    }
}
