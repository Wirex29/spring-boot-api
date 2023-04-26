package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.CreateRoleDTO;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {

    void save(CreateRoleDTO dto);
}
