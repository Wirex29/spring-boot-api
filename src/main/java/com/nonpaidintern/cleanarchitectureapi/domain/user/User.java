package com.nonpaidintern.cleanarchitectureapi.domain.user;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.validator.UserValidator;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.RoleId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;

import java.util.Collection;

import static com.nonpaidintern.cleanarchitectureapi.domain.validator.UserValidator.validateEmail;

public class User extends BaseEntity<UserId> {
    private String firstName;

    private String initials;

    private String lastName;

    private String email;

    private String password;

    private String username;

    private boolean isActive;

    private Collection<RoleId> roles;

    public User() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        validateEmail(email);

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Collection<RoleId> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleId> roles) {
        this.roles = roles;
    }
}
