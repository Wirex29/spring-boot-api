package com.nonpaidintern.cleanarchitectureapi.application.recruit.command.create;

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

            Recruitment recruitment = new Recruitment();
            recruitment.setImgUri(command.img_uri);
            recruitment.setWorkType(command.work_type);
            recruitment.setTitle(command.title);
            recruitment.setPoster(command.poster);
            recruitment.setWorkLocation(command.work_location);
            recruitment.setIncomeProposal(command.income_proposal);
            recruitment.setExperienceRequirement(command.experience_requirement);
            recruitment.setSkillsRequirement(command.skills_requirement.stream().map(TechnologyId::new).collect(
                    Collectors.toSet()));
            recruitment.setPosition(command.position);
            recruitment.setBenefits(command.benefits.stream().map(BenefitId::new).collect(Collectors.toSet()));
            recruitment.setBody(new RecruitmentInfo(command.content));
            recruitment.setExpireAt(command.expire_at);
            recruitment.setStatus(command.status);


            recruitmentService.save(new CreateRecruitmentDTO(recruitment));

        }
    }
}
