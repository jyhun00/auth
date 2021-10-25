package com.growingmom.project.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.growingmom.project.auth.entity.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

   @NotNull
   @Size(min = 3, max = 50)
   private String email;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @Size(min = 3, max = 50)
   private String nickname;

   private String name;

   private Integer age;

   private String Authority;

   public UserDto(User user){
       UserDto.builder()
              .age(user.getAge())
              .nickname(user.getNickname())
              .email(user.getEmail())
              .password(user.getPassword())
              .Authority(user.getAuthority().getAuthorityName())
              .name(user.getName()).build();
   }

}