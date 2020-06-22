package com.spring.faltdor.api.demoapijwt.repository;

import com.spring.faltdor.api.demoapijwt.data.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
}