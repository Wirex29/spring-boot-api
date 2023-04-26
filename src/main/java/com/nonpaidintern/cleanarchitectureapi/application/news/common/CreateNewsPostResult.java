package com.nonpaidintern.cleanarchitectureapi.application.news.common;

import org.springframework.http.HttpStatus;

public record CreateNewsPostResult(HttpStatus status, String message) {
}
