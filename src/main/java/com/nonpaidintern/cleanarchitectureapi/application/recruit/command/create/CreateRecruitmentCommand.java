package com.nonpaidintern.cleanarchitectureapi.application.recruit.command.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.DateTimeProvider;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.RecruitmentService;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.CreateRecruitmentDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.enums.Status;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Recruitment;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.RecruitmentInfo;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.BenefitId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.TechnologyId;
import com.nonpaidintern.cleanarchitectureapi.domain.valueobject.UserId;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecruitmentCommand implements Command {

    private String img_uri;
    private String work_type;
    private String title;
    private String slug_title;
    private UserId poster;
    private String work_location;
    private BigDecimal income_proposal;
    private String experience_requirement;
    private Set<UUID> skills_requirement;
    private String position;
    private Set<UUID> benefits;
    private JSONObject content;
    private OffsetDateTime expire_at;
    private Status status;

    @Component
    static class CreateRecruitmentCommandHandler implements CommandHandler<CreateRecruitmentCommand> {

        private final DateTimeProvider dateTimeProvider;
        private final RecruitmentService recruitmentService;

        @Autowired
        CreateRecruitmentCommandHandler(DateTimeProvider dateTimeProvider, RecruitmentService recruitmentService)
        {
            this.dateTimeProvider = dateTimeProvider;
            this.recruitmentService = recruitmentService;
        }

        @Override
        public void handle(CreateRecruitmentCommand command) {

//            UserId poster = new UserId(command.getPoster())

            Recruitment recruitment = new Recruitment(null,
                    command.getImg_uri(),
                    command.getWork_type(),
                    command.getTitle(),
                    command.getPoster(),
                    command.getWork_location(),
                    command.getIncome_proposal(),
                    command.getExperience_requirement(),
                    command.getSkills_requirement().stream().map(TechnologyId::new).collect(
                            Collectors.toSet()),
                    command.getPosition(),
                    command.getBenefits().stream().map(BenefitId::new).collect(Collectors.toSet()),
                    new RecruitmentInfo(command.getContent()),
                    dateTimeProvider.timeNow(),
                    command.getExpire_at(),
                    command.getStatus()
            );



            recruitmentService.save(new CreateRecruitmentDTO(recruitment));

        }
    }
}
