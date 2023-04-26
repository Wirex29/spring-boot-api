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
@Table(name = "course", indexes = @Index(columnList = "id, slug_title"))
@SecondaryTable(name = "course_body", pkJoinColumns = @PrimaryKeyJoinColumn(name = "course_id"))

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slug_title;

    @ManyToOne
    private User poster;

    private String image_uri;

    private String location;

    private BigDecimal course_tuition;

    private String course_duration;

    private String class_size;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime created_at;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime expired_at;

    private boolean is_expired;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime first_day_of_class;

    private String Schedule;

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


