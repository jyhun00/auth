package com.growingmom.project.auth.service;

import com.growingmom.project.auth.entity.User;
import com.growingmom.project.auth.repository.UserRepository;
import com.growingmom.project.exception.NotActivatedUserException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

   public CustomUserDetailsService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public UserDetails loadUserByUsername(final String email) {
      System.out.println("locadUserbyUsername");
      System.out.println(userRepository.findOneWithAuthorityByEmail(email).get().getEmail());

      return userRepository.findOneWithAuthorityByEmail(email)
         .map(user -> createUser(email, user))
         .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
   }

   private org.springframework.security.core.userdetails.User createUser(String username, User user) {
      if (!user.getActivated()) {
         throw new NotActivatedUserException(username + " -> 활성화되어 있지 않습니다.");
      }
      System.out.println("createUser");
      List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
      grantedAuthority.add(new SimpleGrantedAuthority(user.getAuthority().getAuthorityName()));
      org.springframework.security.core.userdetails.User detailUser = new org.springframework.security.core.userdetails.User(user.getEmail(),
              user.getPassword(),
              grantedAuthority);
      System.out.println(detailUser);
      return detailUser;
   }
}
