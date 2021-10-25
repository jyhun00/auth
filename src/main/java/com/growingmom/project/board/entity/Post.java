package com.growingmom.project.board.entity;


import com.growingmom.project.auth.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="post")
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Post extends Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Board board;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
    List<Reply> replies;



}
