package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.nonpaidintern.cleanarchitectureapi.application.image.command.UploadImageCommand;
import com.nonpaidintern.cleanarchitectureapi.application.image.command.UploadImageDto;
import com.nonpaidintern.cleanarchitectureapi.application.image.query.ImageQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/image/")
public class ImageController {

    private final Mediator mediator;

    @Autowired
    public ImageController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping(path = "{fileName}", produces = "image/png")
    public CompletableFuture<ResponseEntity<byte[]>> downloadImage(@ModelAttribute ImageQuery query) {

        try {
            return CompletableFuture.supplyAsync(() -> mediator.dispatch(query))
                    .thenApply((value) ->
                            ResponseEntity.ok()
                                    .contentType(MediaType.valueOf("image/png"))
                                    .body(value));
        } catch (RuntimeException e) {
            return CompletableFuture.completedFuture(ResponseEntity.notFound().build());
        }

    }

    @PostMapping(path = "upload-image", consumes = "multipart/form-data", produces = "application/json")
    public CompletableFuture<ResponseEntity<UploadImageDto>> uploadImage(@ModelAttribute UploadImageCommand command) {

        return CompletableFuture.supplyAsync(() -> mediator.dispatch(command)).thenApply(ResponseEntity::ok);
    }
}
