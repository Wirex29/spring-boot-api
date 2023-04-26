package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String first_name;

    private String initials;

    private String last_name;

    private String email;

    private String password;

    private String username;

    private boolean is_active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;
}
