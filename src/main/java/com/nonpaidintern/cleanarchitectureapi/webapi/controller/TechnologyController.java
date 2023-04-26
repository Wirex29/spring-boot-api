package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nonpaidintern.cleanarchitectureapi.application.technology.query.index.IndexQuery;
import com.nonpaidintern.cleanarchitectureapi.application.common.contract.ActionResponse;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/technology")
public class TechnologyController {

    private final Mediator mediator;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public TechnologyController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "")
    public CompletableFuture<ResponseEntity<ActionResponse>> index(@ModelAttribute IndexQuery query){

        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(query)).thenApply(dtoList ->
                ResponseEntity.ok().body(new ActionResponse(HttpStatus.OK, mapper.valueToTree(dtoList))));

    }

}
