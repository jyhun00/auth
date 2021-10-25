package com.growingmom.project.board.controller;


import com.growingmom.project.auth.entity.User;
import com.growingmom.project.auth.service.UserService;
import com.growingmom.project.board.dto.ArticleDto;

import com.growingmom.project.board.entity.Post;
import com.growingmom.project.board.entity.Reply;
import com.growingmom.project.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final UserService userService;
    private final PostService postService;

    @PostMapping
    public ResponseEntity writePost(@RequestBody ArticleDto articleDto){

        User user = userService.getMyUserWithAuthority().get();

        postService.savePost(articleDto, user);

        return ResponseEntity.ok().body("상담글 저장 성공");
    }

    @GetMapping("/{postId}")
    public ResponseEntity readPost(@PathVariable Long postId){

        User user = userService.getMyUserWithAuthority().get();
        Post post = postService.readPost(postId, user);

        return ResponseEntity.ok().body(post);
    }

}
