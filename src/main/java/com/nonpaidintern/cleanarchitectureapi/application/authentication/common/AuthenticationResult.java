package com.nonpaidintern.cleanarchitectureapi.application.authentication.common;

import lombok.Data;

@Data
public class AuthenticationResult {

    private Integer statusCode;
    private String content;
}
