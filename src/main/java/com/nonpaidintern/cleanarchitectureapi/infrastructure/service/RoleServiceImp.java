package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.CreateRoleDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.RoleService;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Role;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(CreateRoleDTO dto) {
        Role role = Role.builder()
                .name(dto.role().getName())
                .build();

        roleRepository.save(role);
    }
}
