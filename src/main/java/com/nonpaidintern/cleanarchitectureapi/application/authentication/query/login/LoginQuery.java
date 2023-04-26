package com.nonpaidintern.cleanarchitectureapi.application.authentication.query.login;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.GenericAuthenticationResponse;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.UserService;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginQuery implements Request<GenericAuthenticationResponse> {

    private String user;
    private String password;

    @Service
    static class LoginQueryHandler implements RequestHandler<LoginQuery, GenericAuthenticationResponse> {

        private final UserService userService;

        @Autowired
        LoginQueryHandler(UserService userService) {
            this.userService = userService;
        }

        @Override
        public GenericAuthenticationResponse handle(LoginQuery query) {



            return null;
        }
    }
}
