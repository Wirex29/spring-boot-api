package com.nonpaidintern.cleanarchitectureapi.application.recruit.query.index;

import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.DataMapper;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndexQuery implements Request<Page<RecruitIndexDto>> {
    private Integer page_number;
    private String key;
    private String technology;
    private String job_position;
    private String location;
    private Integer per_page;

    @Component
    static class IndexQueryHandler implements RequestHandler<IndexQuery, Page<RecruitIndexDto>> {

        // Mapper
        private final DataMapper mapper;

        @Autowired
        IndexQueryHandler(@Qualifier("recruitmentMapper") DataMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public Page<RecruitIndexDto> handle(IndexQuery command) {

            Pageable pageRequest = PageRequest.of(command.page_number, command.per_page);

            return mapper.getPaginatedList(pageRequest);
        }

    }
}
