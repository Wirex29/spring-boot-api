package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.RegisterDTO;
import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.UserQueryDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.UserService;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.Role;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.User;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.RoleRepository;
import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(RegisterDTO dto) {

        Collection<Role> roleCollection = dto.user()
                .getRoles()
                .stream()
                .map(roleId -> roleRepository.findById(roleId.value())
                        .orElseThrow())
                        .collect(Collectors.toSet());

        User user = User.builder()
                .firstName(dto.user().getFirstName())
                .initials(dto.user().getInitials())
                .lastName(dto.user().getLastName())
                .email(dto.user().getEmail())
                .password(passwordEncoder.encode(dto.user().getPassword()))
                .username(dto.user().getUsername())
                .isActive(dto.user().isActive())
                .roles(roleCollection)
                .build();

        userRepository.save(user);
    }

    @Override
    public UserQueryDTO findUser(String username) {

        User user = userRepository.findByUsernameOrEmail(username, username);

//        return new UserQueryDTO(user.getFirstName(), user.getInitials(), user.getLastName(), )

        return null;
    }
}
