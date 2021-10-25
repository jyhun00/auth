package com.growingmom.project.board.controller;

import com.growingmom.project.auth.entity.User;
import com.growingmom.project.auth.service.UserService;
import com.growingmom.project.board.dto.ArticleDto;
import com.growingmom.project.board.entity.Reply;
import com.growingmom.project.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final UserService userService;

    @GetMapping("/{replyId}")
    public ResponseEntity readReply(@PathVariable Long replyId){

        User user = userService.getMyUserWithAuthority().orElseThrow();
        Reply reply = replyService.readReply(replyId, user);



        return ResponseEntity.ok().body(reply);
    }

    @PostMapping
    public ResponseEntity writeReply(@RequestBody ArticleDto articleDto){

        User user = userService.getMyUserWithAuthority().get();

        Reply reply = replyService.writeReply(articleDto, user);

        return ResponseEntity.ok().body(reply);
    }

}
