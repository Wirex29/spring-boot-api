package com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.RecruitmentService;
import com.nonpaidintern.cleanarchitectureapi.application.recruit.common.IndexQueryDTO;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndexQuery implements Request<Page<IndexQueryDTO>> {
    private Integer page_number = 1;
    private String key;
    private String technology;
    private String job_position;
    private String location;
    private Integer per_page = 6;

    @Component
    static class IndexQueryHandler implements RequestHandler<IndexQuery, Page<IndexQueryDTO>> {

        private final RecruitmentService recruitmentService;

        IndexQueryHandler(RecruitmentService recruitmentService) {
            this.recruitmentService = recruitmentService;
        }

        @Override
        public Page<IndexQueryDTO> handle(IndexQuery query) {

            PageRequest pageRequest = PageRequest.of(query.getPage_number() - 1, query.getPer_page());

            return recruitmentService.fetchPaginated(pageRequest, query.getKey(), query.getTechnology(), query.getJob_position(), query.getLocation());

        }
    }
}
