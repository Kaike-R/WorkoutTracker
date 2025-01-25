package br.com.kaikedev.workouttracker.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentsResponse {

    private Integer id;

    private String content;

    private UserResponse user;
}
