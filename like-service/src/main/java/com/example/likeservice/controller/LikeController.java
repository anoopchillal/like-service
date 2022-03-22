package com.example.likeservice.controller;

import com.example.likeservice.entity.Like;
import com.example.likeservice.service.LikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/likes")
public class LikeController {

    private static Logger log = LoggerFactory.getLogger(LikeController.class);

    @Autowired
    private LikeService likeService;

    @GetMapping("/like")
    public ResponseEntity<List<Like>> getAllLikes(){
        List<Like> list=likeService.getLike();
        return new ResponseEntity<List<Like>>(list, HttpStatus.OK);
    }

    @PostMapping("/likes")
    public Like saveLike(@RequestBody Like like){
        return likeService.saveLike(like);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity <Like>findById(@PathVariable("id") String id){
//        return new ResponseEntity<Like>((Like) likeService.findById(id),HttpStatus.ACCEPTED);
//    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Like> getAllDataById(@PathVariable("id") String id){
        System.out.println("Inside get id resource");
//        if(Boolean.FALSE.equals(likeService.userIsActive(id)))
//        {
//            throw new UserNotFoundException(UserNotFound + id);//this method checks whether a customer exist with this customer id as well as if there is no such customer with such customer id
//        }

        return new ResponseEntity<Like>((Like) likeService.getAllDataById(id), HttpStatus.FOUND);

    }


    @DeleteMapping("/like/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
        likeService.deleteLike(id);
        return new ResponseEntity<String>("Like deleted successfully!.", HttpStatus.OK);
    }

    @GetMapping("/postsOrComments/{postOrCommentId}/likes/{likeId}")
    public ResponseEntity<Long> getLikesCount(String id) {
        Long likeCount = likeService.getLikesCount(id);
        return new ResponseEntity<>(likeCount, HttpStatus.OK);
    }
}
