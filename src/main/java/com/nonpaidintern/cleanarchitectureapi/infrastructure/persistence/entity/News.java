package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "news", indexes = @Index(columnList = "id, slug_title"))
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slug_title;

    private String image_uri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime created_at;

    private String status;

    @ManyToOne
    private User poster;

}
