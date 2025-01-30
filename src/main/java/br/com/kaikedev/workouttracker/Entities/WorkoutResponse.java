package br.com.kaikedev.workouttracker.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkoutResponse {

    private Integer id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<String> exercises;

    private List<CommentsResponse> comments;

    private UserResponse user;

//    public void setComments(List<Comments> comments) {
//        List<String> commentsString = new ArrayList<>();
//
//
//
//        comments.stream().forEach(comment -> {
//            commentsString.add(comment.getContent());
//        });
//        this.comments = commentsString;
//    }
}
