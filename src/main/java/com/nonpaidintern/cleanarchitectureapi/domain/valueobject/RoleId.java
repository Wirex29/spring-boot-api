package com.nonpaidintern.cleanarchitectureapi.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RoleId(@JsonProperty("roleId") UUID value) {

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return value.equals(((RoleId) o).value());
    }
}