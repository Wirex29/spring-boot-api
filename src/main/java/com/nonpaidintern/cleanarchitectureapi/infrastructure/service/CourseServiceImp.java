package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.CourseService;
import com.nonpaidintern.cleanarchitectureapi.application.course.common.CreateCoursePostDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.OfferId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Course;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.CourseBody;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Offer;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.User;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.CourseRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.OfferRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository, UserRepository userRepository,
                            OfferRepository offerRepository) {
        this.courseRepository = courseRepository;

        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void save(CreateCoursePostDTO dto) {

        User user = userRepository.findById(dto.course().getPoster().value()).orElseThrow();

        Set<Offer> offers = new HashSet<>(offerRepository.findAllById(dto.course().getOffers().stream().map(OfferId::value).collect(
                Collectors.toSet())));

        Set<User> lecturers = new HashSet<>(userRepository.findAllById(dto.course().getLecturers().stream().map(UserId::value).collect(
                Collectors.toSet())));

        Course course = Course.builder()
                .title(dto.course().getTitle())
                .slugTitle(dto.course().getPrettyUrl())
                .poster(user)
                .imageUri(dto.course().getImageUri())
                .location(dto.course().getLocation())
                .courseTuition(dto.course().getCourseTuition())
                .courseDuration(dto.course().getCourseDuration())
                .classSize(dto.course().getClassSize())
                .createdAt(dto.course().getCreatedAt())
                .expiredAt(dto.course().getExpiredAt())
                .status(dto.course().getStatus().toString())
                .firstDayOfClass(dto.course().getFirstDayOfClass())
                .schedule(dto.course().getSchedule())
                .body(new CourseBody(dto.course().getData().getBody()))
                .offers(offers)
                .lecturers(lecturers)
                .build();

        courseRepository.save(course);
    }
}
