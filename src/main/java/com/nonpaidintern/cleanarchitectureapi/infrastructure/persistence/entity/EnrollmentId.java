package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class EnrollmentId implements Serializable {

    private UUID course;
    private UUID student;

}
