package com.growingmom.project.auth.controller;

import com.growingmom.project.auth.dto.UserDto;
import com.growingmom.project.auth.entity.User;
import com.growingmom.project.auth.service.UserService;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) throws DuplicateMemberException {
        User user = userService.signup(userDto);
        UserDto result = new UserDto();
        result.setNickname(user.getNickname());
        result.setEmail(user.getEmail());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('user','admin')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        User user = userService.getMyUserWithAuthority().get();
        UserDto userDto = new UserDto(user);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/user/{email}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String email) {
        User user = userService.getUserWithAuthority(email).get();
        UserDto userDto = new UserDto(user);
        return ResponseEntity.ok(userDto);
    }

}
