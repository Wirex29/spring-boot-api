package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course", indexes = @Index(columnList = "id, slugTitle"))
@SecondaryTable(name = "course_body", pkJoinColumns = @PrimaryKeyJoinColumn(name = "course_id"))

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slugTitle;

    @ManyToOne
    private User poster;

    private String imageUri;

    private String location;

    private BigDecimal courseTuition;

    private String courseDuration;

    private String classSize;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime expiredAt;

    private String status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime firstDayOfClass;

    private String schedule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "body", column = @Column( name = "body", table = "course_body", columnDefinition = "jsonb"))
    })
    private CourseBody body;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @ManyToMany
    @JoinTable(
            name = "course_offer",
            joinColumns =
                @JoinColumn(name = "course_id"),
            inverseJoinColumns =
                @JoinColumn(name = "offer_id")
    )
    private Set<Offer> offers;

    @ManyToMany
    @JoinTable(
            name = "lecturer",
            joinColumns =
                    @JoinColumn(name = "course_id"),
            inverseJoinColumns =
                    @JoinColumn(name = "user_id")
    )
    private Set<User> lecturers;
}


