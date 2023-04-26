package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news", indexes = @Index(columnList = "id, slugTitle"))
@SecondaryTable(name = "news_body", pkJoinColumns = @PrimaryKeyJoinColumn(name = "news_id"))
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String slugTitle;

    private String imageUri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, fallbackPatterns = { "M/d/yy", "dd/MM/yyyy", "yyyy/MM/dd" })
    private OffsetDateTime createdAt;

    private String status;

    @ManyToOne
    private User poster;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "content", column = @Column( name = "content", table = "news_body", columnDefinition = "jsonb"))
    })
    private NewsBody body;

}
