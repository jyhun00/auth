package com.growingmom.project.board.service;

import com.growingmom.project.auth.entity.User;
import com.growingmom.project.board.dto.ArticleDto;
import com.growingmom.project.board.entity.Board;
import com.growingmom.project.board.entity.Post;
import com.growingmom.project.board.entity.Reply;
import com.growingmom.project.board.repository.BoardRepository;
import com.growingmom.project.board.repository.PostRepository;
import com.growingmom.project.board.repository.ReplyRepository;
import com.growingmom.project.exception.NoAuthorityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final PostRepository postRepository;

    public Reply readReply(Long replyId, User user ){

        Reply reply = replyRepository.findById(replyId).orElseThrow();

        replyAuthorityCheck(user, reply.getPost());

        return reply;
    }




    public Reply writeReply(ArticleDto articleDto, User user){

        Post post = postRepository.getById(articleDto.getPostId());

        replyAuthorityCheck(user, post);

        Reply reply = Reply.builder()
                .post(post)
                .build();
        reply.setContents(articleDto.getContents());
        reply.setTitle(articleDto.getTitle());
        reply.setWriterEmail(user.getEmail());
        reply.setWriterNickname(user.getNickname());

        return replyRepository.save(reply);

    }

    private void replyAuthorityCheck(User user, Post post) {
        if(!(user.getEmail() == post.getWriterEmail() || "admin".equals(user.getAuthority().getAuthorityName()))){
            throw new NoAuthorityException();
        }
    }
}
