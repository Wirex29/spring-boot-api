package com.nonpaidintern.cleanarchitectureapi.domain.course;

import com.nonpaidintern.cleanarchitectureapi.domain.common.BaseEntity;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.CourseId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.OfferId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.OffsetDateTime;
import java.util.Set;

public class Course extends BaseEntity<CourseId> {

    private String title;
    private UserId poster;
    private String imageUri;
    private String location;
    private BigDecimal courseTuition;
    private String courseDuration;
    private String classSize;
    private OffsetDateTime createdAt;
    private OffsetDateTime expiredAt;
    private Status status;
    private OffsetDateTime firstDayOfClass;
    private String Schedule;
    private CourseData data;
    private Set<OfferId> offers;
    private Set<UserId> lecturers;

    public Course() {}

    public String getPrettyUrl() {
        return Normalizer.normalize(this.title.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{Alnum}]+", "-");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserId getPoster() {
        return poster;
    }

    public void setPoster(UserId poster) {
        this.poster = poster;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getCourseTuition() {
        return courseTuition;
    }

    public void setCourseTuition(BigDecimal courseTuition) {
        this.courseTuition = courseTuition;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getClassSize() {
        return classSize;
    }

    public void setClassSize(String classSize) {
        this.classSize = classSize;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(OffsetDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OffsetDateTime getFirstDayOfClass() {
        return firstDayOfClass;
    }

    public void setFirstDayOfClass(OffsetDateTime firstDayOfClass) {
        this.firstDayOfClass = firstDayOfClass;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public CourseData getData() {
        return data;
    }

    public void setData(CourseData data) {
        this.data = data;
    }

    public Set<OfferId> getOffers() {
        return offers;
    }

    public void setOffers(Set<OfferId> offers) {
        this.offers = offers;
    }

    public Set<UserId> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<UserId> lecturers) {
        this.lecturers = lecturers;
    }
}
