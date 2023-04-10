package com.nonpaidintern.cleanarchitectureapi.application.authentication.query.login;

import an.awesome.pipelinr.Command;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.AuthenticationResponse;
import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Query<AuthenticationResponse> {

    private String user;
    private String password;

    @Component
    static class Handler implements Command.Handler<LoginRequest, AuthenticationResponse> {

        @Override
        public AuthenticationResponse handle(LoginRequest command) {
            return null;
        }

        @Override
        public boolean matches(LoginRequest command) {
            return Command.Handler.super.matches(command);
        }
    }

}
