package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.RegisterDTO;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.UserQueryDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    void save(RegisterDTO dto);

    UserQueryDTO findUser(String username);

}
