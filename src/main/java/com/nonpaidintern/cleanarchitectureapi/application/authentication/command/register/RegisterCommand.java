package com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register;

import an.awesome.pipelinr.Command;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.AuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCommand implements Command<AuthenticationResponse> {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Component
    static class Handler implements Command.Handler<RegisterCommand, AuthenticationResponse> {

        @Override
        public AuthenticationResponse handle(RegisterCommand command) {
            return null;
        }

        @Override
        public boolean matches(RegisterCommand command) {
            return Command.Handler.super.matches(command);
        }
    }
}
