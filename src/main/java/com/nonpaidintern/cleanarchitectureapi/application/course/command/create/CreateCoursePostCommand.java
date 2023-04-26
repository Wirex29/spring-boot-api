package com.nonpaidintern.cleanarchitectureapi.application.course.command.create;

import com.fasterxml.jackson.databind.JsonNode;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.CourseService;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.DateTimeProvider;
import com.nonpaidintern.cleanarchitectureapi.application.course.common.CreateCoursePostDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.course.Course;
import com.nonpaidintern.cleanarchitectureapi.domain.course.CourseData;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.OfferId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCoursePostCommand implements Command {

    private String title;
    private UserId poster;
    private String imageUri;
    private String location;
    private BigDecimal courseTuition;
    private String courseDuration;
    private String classSize;
    private OffsetDateTime expiredAt;
    private Status status;
    private OffsetDateTime firstDayOfClass;
    private String schedule;
    private JsonNode data;
    private Set<OfferId> offers;
    private Set<UserId> lecturers;

    @Service
    static class CreateCoursePostCommandHandler implements CommandHandler<CreateCoursePostCommand> {

        private final DateTimeProvider dateTimeProvider;
        private final CourseService courseService;

        @Autowired
        CreateCoursePostCommandHandler(DateTimeProvider dateTimeProvider, CourseService courseService) {
            this.dateTimeProvider = dateTimeProvider;
            this.courseService = courseService;
        }

        @Override
        public void handle(CreateCoursePostCommand command) {
            Course course = new Course();
            course.setTitle(command.title);
            course.setPoster(command.poster);
            course.setImageUri(command.imageUri);
            course.setLocation(command.location);
            course.setCourseTuition(command.courseTuition);
            course.setCourseDuration(command.courseDuration);
            course.setClassSize(command.classSize);
            course.setCreatedAt(dateTimeProvider.timeNow());
            course.setExpiredAt(command.expiredAt);
            course.setStatus(Status.ACTIVE);
            course.setFirstDayOfClass(command.firstDayOfClass);
            course.setSchedule(command.schedule);
            course.setData(new CourseData(command.data));
            course.setOffers(command.offers);
            course.setLecturers(command.lecturers);

            courseService.save(new CreateCoursePostDTO(course));
        }
    }
}
