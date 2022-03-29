package com.example.likeservice.repository;

import com.example.likeservice.entity.Like;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface LikeRepository extends MongoRepository<Like, String> {

    public List<Like> findBypostorcommentID(String postOrCommentId, Pageable firstPage);

}
