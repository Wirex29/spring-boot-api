package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import an.awesome.pipelinr.Pipeline;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.AuthenticationResponse;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register.RegisterCommand;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.query.login.LoginRequest;
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

    private final Pipeline pipeline;

    @Autowired
    public AuthenticationController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping(path = "/login")
    public CompletableFuture<ResponseEntity<AuthenticationResponse>> login(@ModelAttribute LoginRequest request) {

        CompletableFuture<AuthenticationResponse> future = CompletableFuture.supplyAsync(() ->
                                                                                    request.execute(pipeline));

        return future.thenApply(ResponseEntity::ok);
    }

    @PostMapping(path = "/register")
    public CompletableFuture<ResponseEntity<AuthenticationResponse>> register(@ModelAttribute RegisterCommand command) {
        CompletableFuture<AuthenticationResponse> future = CompletableFuture.supplyAsync(() ->
                                                                                    command.execute(pipeline));

        return future.thenApply(ResponseEntity::ok);
    }

}
