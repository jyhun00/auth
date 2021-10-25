package com.growingmom.project.board.repository;


import com.growingmom.project.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    public List<Reply> findRepliesByPostId(Long postId);

}
