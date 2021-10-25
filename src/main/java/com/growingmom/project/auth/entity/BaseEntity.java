package com.growingmom.project.auth.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter
@Setter
public class BaseEntity {
    @CreatedDate
    @Column(name="create_at", updatable = false)
    private LocalDateTime createAt;
    @LastModifiedDate
    @Column(name="update_at", updatable = true)
    private LocalDateTime updateAt;
    @CreatedBy
    @Column(name="creator", updatable = false)
    private String createdBy;
    @LastModifiedBy
    @Column(name="modifier", updatable = true)
    private String modifiedBy;
}
