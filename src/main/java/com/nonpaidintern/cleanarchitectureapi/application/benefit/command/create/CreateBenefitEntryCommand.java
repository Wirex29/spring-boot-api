package com.nonpaidintern.cleanarchitectureapi.application.benefit.command.create;

import com.nonpaidintern.cleanarchitectureapi.application.benefit.common.CreateBenefitEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.BenefitService;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Benefit;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBenefitEntryCommand implements Command {
    private String name;
    private String description;
    private String iconUri;

    @Component
    static class CreateBenefitEntryCommandHandler implements CommandHandler<CreateBenefitEntryCommand> {

        private final BenefitService benefitService;

        @Autowired
        CreateBenefitEntryCommandHandler(BenefitService benefitService) {
            this.benefitService = benefitService;
        }

        @Override
        public void handle(CreateBenefitEntryCommand command) {
            Benefit benefit = new Benefit();
            benefit.setName(command.getName());
            benefit.setDescription(command.getDescription());
            benefit.setIconUri(command.getIconUri());

            benefitService.save(new CreateBenefitEntryDTO(benefit));
        }
    }

}
