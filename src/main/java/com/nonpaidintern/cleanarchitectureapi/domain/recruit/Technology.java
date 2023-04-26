package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.TechnologyId;

public class Technology extends BaseEntity<TechnologyId> {

    private String name;

    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
