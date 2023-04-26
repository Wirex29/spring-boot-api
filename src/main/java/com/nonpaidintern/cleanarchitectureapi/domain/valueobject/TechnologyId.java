package com.nonpaidintern.cleanarchitectureapi.domain.valueobject;

import java.util.UUID;

public record TechnologyId(UUID value) {
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return value.equals(((TechnologyId) o).value());
    }
}
