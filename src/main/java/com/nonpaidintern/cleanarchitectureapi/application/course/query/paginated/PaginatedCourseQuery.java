package com.nonpaidintern.cleanarchitectureapi.application.course.query.paginated;

import lombok.Data;

@Data
public class PaginatedCourseQuery {
    private String key;
    private String location;
    private String training_time;
    private String target;
    private String topic;
}
