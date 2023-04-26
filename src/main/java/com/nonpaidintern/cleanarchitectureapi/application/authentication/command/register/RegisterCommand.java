package com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.RegisterDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.UserService;
import com.nonpaidintern.cleanarchitectureapi.domain.user.User;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.RoleId;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCommand implements Command {

    private String firstName;
    private String initials;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private RoleId role;

    @Component
    static class RegisterCommandHandler implements CommandHandler<RegisterCommand> {

        private final UserService userService;


        @Autowired
        RegisterCommandHandler(UserService userService) {
            this.userService = userService;
        }

        @Override
        public void handle(RegisterCommand command) {
            User user = new User();
            user.setFirstName(command.firstName);
            user.setInitials(command.initials);
            user.setLastName(command.lastName);
            user.setEmail(command.email);
            user.setPassword(command.password);
            user.setUsername(command.username);
            user.setActive(true);
            user.setRoles(Collections.singletonList(command.role));

            userService.save(new RegisterDTO(user));
        }
    }

}
