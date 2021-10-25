package com.growingmom.project.config;

import com.growingmom.project.auth.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = "";
        if(null != auth)
            name = auth.getName();
        String finalName = name;
        return () -> Optional.of(finalName);
    }

}
