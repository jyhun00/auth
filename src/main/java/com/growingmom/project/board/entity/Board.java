package com.growingmom.project.board.entity;

import com.growingmom.project.auth.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="board")
@EntityListeners(value={AuditingEntityListener.class})
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "board")
    List<Post> posts;

    @Column(name="manager_id")
    private long managerId;

}
