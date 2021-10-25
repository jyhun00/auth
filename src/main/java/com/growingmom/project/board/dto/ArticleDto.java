package com.growingmom.project.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class ArticleDto {

    Long boardId;

    Long postId;

    String title;

    String contents;

    Long writerId;

    String writeName;
}
