package com.nonpaidintern.cleanarchitectureapi.application.common.mapper;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Recruitment;

public class UserMapper implements Mapper<Recruitment, com.nonpaidintern.cleanarchitectureapi.domain.recruit.Recruitment>{

    @Override
    public com.nonpaidintern.cleanarchitectureapi.domain.recruit.Recruitment dtoToEntity(Recruitment dto) {
        return null;
    }

    @Override
    public Recruitment entityToDto(com.nonpaidintern.cleanarchitectureapi.domain.recruit.Recruitment entity) {
        return null;
    }
}
