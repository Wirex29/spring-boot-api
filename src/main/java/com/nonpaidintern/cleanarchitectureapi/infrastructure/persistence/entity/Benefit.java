package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@Getter
@Table(name = "benefit")
@NoArgsConstructor
@AllArgsConstructor
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    private String description;

    private String icon_uri;
}
