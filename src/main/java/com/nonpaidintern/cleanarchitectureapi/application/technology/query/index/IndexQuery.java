package com.nonpaidintern.cleanarchitectureapi.application.technology.query.index;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.TechnologyService;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class IndexQuery implements Request<List<TechnologyIndexDTO>> {

    @Component
    static class TechnologyIndexQueryHandler implements RequestHandler<IndexQuery, List<TechnologyIndexDTO>> {

        private final TechnologyService technologyService;

        TechnologyIndexQueryHandler(TechnologyService technologyService) {
            this.technologyService = technologyService;
        }

        @Override
        public List<TechnologyIndexDTO> handle(IndexQuery query) {
            return technologyService.fetchAll();
        }
    }
}
