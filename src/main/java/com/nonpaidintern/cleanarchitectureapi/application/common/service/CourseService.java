package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.course.common.CreateCoursePostDTO;

public interface CourseService {

    void save(CreateCoursePostDTO dto);
}
