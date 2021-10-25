package com.growingmom.project.board.service;


import com.growingmom.project.auth.entity.User;
import com.growingmom.project.board.dto.ArticleDto;
import com.growingmom.project.board.entity.Board;
import com.growingmom.project.board.entity.Post;
import com.growingmom.project.board.repository.BoardRepository;
import com.growingmom.project.board.repository.PostRepository;
import com.growingmom.project.exception.DataNotFoundException;
import com.growingmom.project.exception.NoAuthorityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final BoardRepository boardRepository;

//    public Post readPost(){
//
//        Post post = postRepository.findById(postId).orElseThrow();
//
//
//        if(post.getCreatedBy() != userNo){
//            throw new RuntimeException();
//        }
//
//        return post;
//    }

    public Post savePost(ArticleDto articleDto, User user){
        Board board = boardRepository.findById(articleDto.getBoardId()).orElseThrow(() -> new DataNotFoundException());

        Post post = Post.builder()
                .board(board).build();
            post.setContents(articleDto.getContents());
            post.setTitle(articleDto.getTitle());
            post.setWriterEmail(user.getEmail());
            post.setWriterNickname(user.getNickname());

        return postRepository.save(post);

    }

    public Post readPost(Long postId, User user){
        Post post = postRepository.findById(postId).orElseThrow();
        if(!(post.getWriterEmail() == user.getEmail()
                || "admin".equals(user.getAuthority().getAuthorityName()))){
            throw new NoAuthorityException();
        }
        return post;
    }





}
