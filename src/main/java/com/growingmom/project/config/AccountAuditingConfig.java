package com.growingmom.project.config;

import com.growingmom.project.auth.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Component("accountAuditAware")
public class AccountAuditingConfig implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.empty();
    }
}
