package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsernameOrEmail(@NonNull String username, @NonNull String email);

}
