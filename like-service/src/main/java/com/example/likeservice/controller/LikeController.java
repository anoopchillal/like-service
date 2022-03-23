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
@RequestMapping("/likes")
public class LikeController {

    private static Logger log = LoggerFactory.getLogger(LikeController.class);

    @Autowired
    private LikeService likeService;

    @GetMapping("/postsOrComments/{postOrCommentId}/likes")
    public ResponseEntity<List<Like>> likesPage(@PathVariable("postOrCommentId") String postOrCommentId, @QueryParam("page") int page, @QueryParam("pageSize") int pageSize){
        return new ResponseEntity<>(likeService.likesPage(postOrCommentId,page,pageSize), HttpStatus.ACCEPTED);
    }

    @PostMapping("/postsOrComments/{postOrCommentId}/likes")
    public ResponseEntity<Like> likeCreate(@PathVariable("postOrCommentId") String postOrCommentId, @RequestBody @Valid Like like){
        return new ResponseEntity<>(likeService.likeCreate(like,postOrCommentId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/postsOrComments/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<Like> likeDetailsByID(@PathVariable("likeId") String Id, @PathVariable("postOrCommentId") String postOrCommentId) {
        return new ResponseEntity<>(likeService.likeDetailsByID(Id), HttpStatus.ACCEPTED);
    }
}
