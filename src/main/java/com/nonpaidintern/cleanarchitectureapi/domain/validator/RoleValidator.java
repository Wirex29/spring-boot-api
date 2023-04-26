package com.nonpaidintern.cleanarchitectureapi.domain.validator;

public class RoleValidator {

    public static boolean validateRoleName(String roleName) {

        if(roleName == null) throw new IllegalArgumentException("Role name can't be null");

        if(roleName.isBlank()) throw new IllegalArgumentException("Role name can't be blank");

        return true;
    }
}
