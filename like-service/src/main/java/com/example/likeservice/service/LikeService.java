package com.example.likeservice.service;

import com.example.likeservice.entity.Like;
import com.example.likeservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getLike() {
        return likeRepository.findAll();
    }

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public Object getAllDataById(String id) {
        return likeRepository.findById(id).get();
    }


    public void deleteLike(String id) {
        likeRepository.deleteById(id);
    }

    public Long getLikesCount(String id) {
        Long count=likeRepository.countById(id);
        return count;
    }


}
