package com.nonpaidintern.cleanarchitectureapi.application.authentication.command.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCommand {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;


}
