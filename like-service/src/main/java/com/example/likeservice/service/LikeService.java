package com.example.likeservice.service;

import com.example.likeservice.entity.Like;
import com.example.likeservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;


    public List<Like> likesPage(String postOrCommentId, int page, int pageSize) {
        Pageable firstPage = PageRequest.of(page, pageSize);
        List<Like> allLikes=likeRepository.findBypostorcommentID(postOrCommentId,firstPage);
        return  allLikes;
    }

    public Like likeCreate(Like like, String postOrCommentId) {
        like.setPostorcommentID(postOrCommentId);
        like.setCreatedAt(LocalDateTime.now());
        return likeRepository.save(like);
    }

    public Like likeDetailsByID(String likeId) {
        return likeRepository.findById(likeId).get();
    }

    public String deleteLikeID(String likeId) {
        likeRepository.deleteById(likeId);
        return "Deleted  "+likeId+" successfully";
    }

    public int countLikes(String postOrCommentId) {
        List<Like> allData=likeRepository.findAll();
        int count=0;
        for(Like like:allData){
            if(like.getPostorcommentID().equals(postOrCommentId)){
                count++;
            }
        }
        return count;
    }
}
