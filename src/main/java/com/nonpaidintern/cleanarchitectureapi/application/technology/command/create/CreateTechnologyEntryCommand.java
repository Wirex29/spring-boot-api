package com.nonpaidintern.cleanarchitectureapi.application.technology.command.create;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.TechnologyService;
import com.nonpaidintern.cleanarchitectureapi.application.technology.common.CreateTechnologyEntryDTO;
import com.nonpaidintern.cleanarchitectureapi.domain.recruit.Technology;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnologyEntryCommand implements Command {

    private String name;

    @Service
    static class CreateTechnologyEntryHandler implements CommandHandler<CreateTechnologyEntryCommand> {

        private final TechnologyService technologyService;

        @Autowired
        CreateTechnologyEntryHandler(TechnologyService technologyService) {
            this.technologyService = technologyService;
        }

        @Override
        public void handle(CreateTechnologyEntryCommand command) {
            Technology technology = new Technology(command.name);

            technologyService.save(new CreateTechnologyEntryDTO(technology));
        }
    }
}
