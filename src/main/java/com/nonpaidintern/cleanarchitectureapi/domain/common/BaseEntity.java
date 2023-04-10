package com.nonpaidintern.cleanarchitectureapi.domain.common;

import java.util.UUID;

public abstract class BaseEntity {

    protected UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
