package com.nonpaidintern.cleanarchitectureapi.application.benefit.query.index;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.BenefitService;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class IndexQuery implements Request<List<BenefitIndexDTO>> {

    @Component
    static class BenefitIndexQueryHandler implements RequestHandler<IndexQuery, List<BenefitIndexDTO>> {

        private final BenefitService benefitService;

        @Autowired
        BenefitIndexQueryHandler(BenefitService benefitService) {
            this.benefitService = benefitService;
        }

        @Override
        public List<BenefitIndexDTO> handle(IndexQuery query) {

            return benefitService.fetchAll();
        }
    }
}
