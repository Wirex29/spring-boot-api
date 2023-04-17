package com.nonpaidintern.cleanarchitectureapi.application.authentication.common;

import lombok.Data;

@Data
public class AuthenticationResult {

    private Integer status;
    private String content;
}
