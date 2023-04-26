package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register.RegisterCommand;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.command.role.CreateRoleCommand;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.GenericAuthenticationResponse;
import com.nonpaidintern.cleanarchitectureapi.application.common.contract.ActionResponse;
import com.nonpaidintern.cleanarchitectureapi.application.news.command.create.CreateNewsPostCommand;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.command.create.CreateRecruitmentCommand;
import com.nonpaidintern.cleanarchitectureapi.application.technology.command.create.CreateTechnologyEntryCommand;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final Mediator mediator;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public AdminController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping(path = "/create/recruitment", consumes = "application/json")
    public CompletableFuture<ResponseEntity<ActionResponse>> createRecruitmentPost(@RequestBody CreateRecruitmentCommand command)
    {

//        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(command)).thenApply(ResponseEntity::ok);
        this.mediator.dispatch(command);

        return CompletableFuture.completedFuture(ResponseEntity.ok().body(
                new ActionResponse(HttpStatus.OK, mapper.valueToTree(command))
        ));
    }

    /**
     * Create new role
     *
     * @param command json data containing all required fields for creating new role. It will then be handled by Command Handler.
     **/
    @PostMapping(path = "/create/role", consumes = "application/json")
    public CompletableFuture<ResponseEntity<GenericAuthenticationResponse>> createRole(@RequestBody CreateRoleCommand command) {

        try {

            this.mediator.dispatch(command);

            return CompletableFuture.completedFuture(ResponseEntity.ok()
                    .body(new GenericAuthenticationResponse(200,
                            String.format("Created new role %s successfully", command.getRoleName()))));

        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest()
                    .body(new GenericAuthenticationResponse(400, e.getMessage())));
        }
    }

    @PostMapping(path = "/create/user", consumes = "application/json")
    public CompletableFuture<ResponseEntity<GenericAuthenticationResponse>> createUser(@RequestBody RegisterCommand command) {

        try {

            this.mediator.dispatch(command);

            return CompletableFuture.completedFuture(ResponseEntity.ok()
                    .body(new GenericAuthenticationResponse(200,
                            String.format("Created new user %s / %s successfully",
                                    command.getEmail(),
                                    command.getUsername()))));

        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest()
                    .body(new GenericAuthenticationResponse(400, e.getMessage())));
        }
    }

    @PostMapping(path = "/create/news", consumes = "application/json")
    public CompletableFuture<ResponseEntity<ActionResponse>> createNewsPost(@RequestBody CreateNewsPostCommand command) {

        this.mediator.dispatch(command);

        return CompletableFuture.completedFuture(ResponseEntity.ok()
                .body(new ActionResponse(HttpStatus.OK, mapper.valueToTree(command))));
    }

    @PostMapping(path = "/create/technology", consumes = "application/json")
    public CompletableFuture<ResponseEntity<ActionResponse>> createTechnologyEntry(@RequestBody CreateTechnologyEntryCommand command) {

        this.mediator.dispatch(command);

        return CompletableFuture.completedFuture(ResponseEntity.ok()
                .body(new ActionResponse(HttpStatus.OK, mapper.valueToTree(command)))
        );
    }


}
