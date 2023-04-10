package com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index;

import an.awesome.pipelinr.Command;
import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitIndexRequest implements Query<Page<RecruitIndexDto>> {
    private Integer page_number;
    private String key;
    private String technology;
    private String job_position;
    private String location;
    private Integer per_page;

    @Component
    static class Handler implements Command.Handler<RecruitIndexRequest, Page<RecruitIndexDto>> {

        @Override
        public Page<RecruitIndexDto> handle(RecruitIndexRequest command) {

            var pr = PageRequest.of(command.page_number, command.per_page);

            return null;
        }

        @Override
        public boolean matches(RecruitIndexRequest command) {
            return Command.Handler.super.matches(command);
        }
    }
}
