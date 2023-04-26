package com.nonpaidintern.cleanarchitectureapi.domain.recruit;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.BenefitId;

public class Benefit extends BaseEntity<BenefitId> {

    private String name;
    private String description;
    private String iconUri;

    public Benefit() {}

    public Benefit(String name, String description, String iconUri) {
        this.name = name;
        this.description = description;
        this.iconUri = iconUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }
}
