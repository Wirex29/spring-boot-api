package com.nonpaidintern.cleanarchitectureapi.application.authentication.query.login;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.AuthenticationResult;
import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginQuery implements Request<AuthenticationResult> {

    private String user;
    private String password;


}
