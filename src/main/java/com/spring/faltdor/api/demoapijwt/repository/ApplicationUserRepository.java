package com.spring.faltdor.api.demoapijwt.repository;

import com.spring.faltdor.api.demoapijwt.data.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser  findByUserName(String username);
}