package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register.RegisterCommand;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.command.role.CreateRoleCommand;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.GenericAuthenticationResponse;
import com.nonpaidintern.cleanarchitectureapi.application.news.command.create.CreateNewsPostCommand;
import com.nonpaidintern.cleanarchitectureapi.application.news.common.CreateNewsPostResult;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.command.create.CreateRecruitmentCommand;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.CreateRecruitmentResult;
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

    @Autowired
    public AdminController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping(value = "/create-new-recruitment", consumes = "application/json")
    public CompletableFuture<ResponseEntity<CreateRecruitmentResult>> createRecruitmentPost(@ModelAttribute CreateRecruitmentCommand command)
    {

//        return CompletableFuture.supplyAsync(() -> this.mediator.dispatch(command)).thenApply(ResponseEntity::ok);
        try {
            this.mediator.dispatch(command);

            return CompletableFuture.completedFuture(ResponseEntity.ok().build());

        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest()
                    .body(new CreateRecruitmentResult(400, e.getMessage())));
        }

    }

    /**
     * Create new role
     *
     * @param command json data containing all required fields for creating new role. It will then be handled by {@link com.nonpaidintern.cleanarchitectureapi.application.authentication.command.role.CreateRoleCommand.CreateRoleCommandHandler }
     **/
    @PostMapping(value = "/create-new-role", consumes = "application/json")
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

    @PostMapping(value = "/create-new-user", consumes = "application/json")
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

    @PostMapping(value = "/create-post/news", consumes = "application/json")
    public CompletableFuture<ResponseEntity<CreateNewsPostResult>> createUser(@RequestBody CreateNewsPostCommand command) {

        this.mediator.dispatch(command);

        return CompletableFuture.completedFuture(ResponseEntity.ok()
                .body(new CreateNewsPostResult(HttpStatus.OK, "Created new post of type news")));
    }


}
