package com.nonpaidintern.cleanarchitectureapi.domain.common;

public abstract class BaseEntity<T> {

    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
