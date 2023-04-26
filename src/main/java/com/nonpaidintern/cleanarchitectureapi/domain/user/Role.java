package com.nonpaidintern.cleanarchitectureapi.domain.user;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.validator.RoleValidator;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.RoleId;

public class Role extends BaseEntity<RoleId> {

    private String name;

    public Role() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (RoleValidator.validateRoleName(name)) this.name = name;

    }
}
