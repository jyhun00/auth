package com.growingmom.project.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LogoutDto {
    String message;
    String redirectUrl;
}
