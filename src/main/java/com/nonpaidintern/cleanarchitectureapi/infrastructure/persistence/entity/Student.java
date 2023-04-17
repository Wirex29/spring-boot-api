package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String full_name;

    private String sex;

    private String phone_number;

    private LocalDate date_of_birth;

    private String email;

    private String graduated_at;

    private Integer year_of_graduation;

    private String major;

    private Float gpa;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;
}
