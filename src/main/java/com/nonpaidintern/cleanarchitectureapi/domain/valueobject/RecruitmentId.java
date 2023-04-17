package com.nonpaidintern.cleanarchitectureapi.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class RecruitmentId{

    private final UUID value;

    public RecruitmentId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null || getClass() != o.getClass()) return false;
        return value.equals(((RecruitmentId) o).getValue());
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
