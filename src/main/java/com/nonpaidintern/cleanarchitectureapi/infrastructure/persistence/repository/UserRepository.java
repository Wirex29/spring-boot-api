package com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.repository;

import com.nonpaidintern.cleanarchitectureapi.infrastructure.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
