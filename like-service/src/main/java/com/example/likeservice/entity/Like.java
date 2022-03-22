package com.example.likeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Like {

    @Id
    private String id;
    private String postOrCommentId;
    private String likedBy;

}
