package com.growingmom.project.auth.repository;



import com.growingmom.project.auth.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//   @EntityGraph(attributePaths = "authorities")
//   Optional<User> findOneWithAuthoritiesByUsername(String username);

   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByEmail(String email);


   @EntityGraph(attributePaths = "authority")
   Optional<User> findOneWithAuthorityByEmail(String email);

}
