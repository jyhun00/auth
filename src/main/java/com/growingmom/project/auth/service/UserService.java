package com.growingmom.project.auth.service;


import com.growingmom.project.auth.dto.UserDto;
import com.growingmom.project.auth.entity.Authority;
import com.growingmom.project.auth.entity.User;
import com.growingmom.project.auth.repository.AuthorityRepository;
import com.growingmom.project.auth.repository.UserRepository;
import com.growingmom.project.util.SecurityUtil;
import javassist.bytecode.DuplicateMemberException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @Transactional
    public User signup(UserDto userDto) throws DuplicateMemberException {
        if (userRepository.findOneWithAuthorityByEmail(userDto.getEmail()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = authorityRepository.findAuthorityByAuthorityName("user").orElseThrow();

        User user = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authority(authority)
                .age(userDto.getAge())
                .name(userDto.getName())
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthority(String email) {
        return userRepository.findOneWithAuthorityByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthority() {
        return SecurityUtil.getCurrentEmail().flatMap(userRepository::findOneWithAuthorityByEmail);
    }
}
