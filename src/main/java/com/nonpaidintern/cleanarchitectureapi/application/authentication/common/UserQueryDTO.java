package com.nonpaidintern.cleanarchitectureapi.application.authentication.common;

import java.util.Collection;

public record UserQueryDTO(String firstName, String initials, String lastName, String email, String username,
                           String password,
                           Collection<String> roles, boolean isActive) {
}
