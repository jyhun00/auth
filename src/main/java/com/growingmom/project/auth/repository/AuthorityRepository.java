package com.growingmom.project.auth.repository;

import com.growingmom.project.auth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findAuthorityByAuthorityName(String authorityName);
}
