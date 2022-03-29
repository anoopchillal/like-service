package com.example.likeservice.controller;


import com.example.likeservice.entity.Like;
import com.example.likeservice.service.LikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import java.util.List;


@RestController
@RequestMapping("/postsOrComments")
public class LikeController {

    private static Logger log = LoggerFactory.getLogger(LikeController.class);

    @Autowired
    LikeService likeService;

    @GetMapping("/{postOrCommentId}/likes")
    public ResponseEntity<List<Like>> likesPage(@PathVariable("postOrCommentId") String postOrCommentId, @QueryParam("page") int page, @QueryParam("pageSize") int pageSize){
        return new ResponseEntity<>(likeService.likesPage(postOrCommentId,page,pageSize), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{postOrCommentId}/likes")
    public ResponseEntity<Like> likeCreate(@PathVariable("postOrCommentId") String postOrCommentId, @RequestBody @Valid Like like){
        return new ResponseEntity<>(likeService.likeCreate(like,postOrCommentId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<Like> likeDetailsByID(@PathVariable("likeId") String likeId, @PathVariable("postOrCommentId") String postOrCommentId) {
        return new ResponseEntity<>(likeService.likeDetailsByID(postOrCommentId,likeId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<String> deleteLikeID(@PathVariable("likeId") String likeId, @PathVariable("postOrCommentId") String postOrCommentId ) {
        return new ResponseEntity<>(likeService.deleteLikeID(likeId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{postOrCommentId}/likes/count")
    public ResponseEntity<Integer> countLikes(@PathVariable("postOrCommentId") String postOrCommentId){
        return new ResponseEntity<>(likeService.countLikes(postOrCommentId), HttpStatus.ACCEPTED);
    }

}
