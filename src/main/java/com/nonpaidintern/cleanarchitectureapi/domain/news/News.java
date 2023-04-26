package com.nonpaidintern.cleanarchitectureapi.domain.news;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.NewsId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;

import java.text.Normalizer;
import java.time.OffsetDateTime;

public class News extends BaseEntity<NewsId> {

    private UserId poster;
    private String title;
    private String imageUri;
    private OffsetDateTime createdAt;
    private NewsBody body;
    private Status status;

    public News(){}

    public News(UserId poster, String title, String imageUri, OffsetDateTime createdAt, NewsBody body, Status status) {
        this.poster = poster;
        this.title = title;
        this.imageUri = imageUri;
        this.createdAt = createdAt;
        this.body = body;
        this.status = status;
    }

    public String getPrettyUrl() {
        return Normalizer.normalize(this.title.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{Alnum}]+", "-");
    }

    public UserId getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUri() {
        return imageUri;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public NewsBody getBody() {
        return body;
    }

    public Status getStatus() {
        return status;
    }

    public void setPoster(UserId poster) {
        this.poster = poster;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setBody(NewsBody body) {
        this.body = body;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
