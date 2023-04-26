package com.nonpaidintern.cleanarchitectureapi.domain.validator;

import java.util.regex.Pattern;

public class UserValidator {

    public static void validateEmail(String email) {


        if (!Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
                .matcher(email)
                .matches()) throw new IllegalArgumentException("Invalid Email address");
    }
}
