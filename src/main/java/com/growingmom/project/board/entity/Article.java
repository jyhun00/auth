package com.growingmom.project.board.entity;

import com.growingmom.project.auth.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter
@Setter
public class Article extends BaseEntity {

    private String writerEmail;

    private String writerNickname;

    private String title;

    private String contents;

}
