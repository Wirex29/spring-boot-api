package com.nonpaidintern.cleanarchitectureapi.webapi.controller;


import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.AuthenticationResult;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.query.login.LoginQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {

    private final Mediator mediator;

    @Autowired
    public AuthenticationController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping(path = "/login")
    public CompletableFuture<ResponseEntity<AuthenticationResult>> login(@ModelAttribute LoginQuery request) {

        CompletableFuture<AuthenticationResult> future = CompletableFuture.supplyAsync(() ->
                                                                                    this.mediator.dispatch(request));

        return future.thenApply(ResponseEntity::ok);
    }

//    @PostMapping(path = "/register")
//    public CompletableFuture<ResponseEntity<AuthenticationResult>> register(@ModelAttribute RegisterCommand command) {
//        CompletableFuture<AuthenticationResult> future = CompletableFuture.supplyAsync(() ->
//                                                                                    command.execute(pipeline));
//
//        return future.thenApply(ResponseEntity::ok);
//    }

}
