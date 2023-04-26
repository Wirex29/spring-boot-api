package com.nonpaidintern.cleanarchitectureapi.domain.valueobject;

import java.util.UUID;

public record CourseId(UUID value) {

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return value.equals(((CourseId) o).value());
    }
}
