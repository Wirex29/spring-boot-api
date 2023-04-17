package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Entity
@Builder
@Table(name = "enrollment")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EnrollmentId.class)
public class Enrollment {

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    private boolean full_time_student;

    private String location;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime enrolled_at;
}
