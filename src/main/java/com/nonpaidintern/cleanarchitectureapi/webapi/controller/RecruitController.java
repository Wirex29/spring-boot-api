package com.nonpaidintern.cleanarchitectureapi.webapi.controller;

import com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index.RecruitIndexDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/recruit")
public class RecruitController {

    @GetMapping(path = "",
                produces = {"application/json"}
    )
    public CompletableFuture<ResponseEntity<List<RecruitIndexDto>>> index() {
        return null;
    }


}
