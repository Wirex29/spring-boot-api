package com.nonpaidintern.cleanarchitectureapi.webapi.controller;


import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.GenericAuthenticationResponse;
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
    public CompletableFuture<ResponseEntity<GenericAuthenticationResponse>> login(@ModelAttribute LoginQuery request) {

        try {
            return CompletableFuture.supplyAsync(() ->
                    this.mediator.dispatch(request)).thenApply(ResponseEntity::ok);
        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(new GenericAuthenticationResponse(400, e.getMessage())));
        }

    }


}
