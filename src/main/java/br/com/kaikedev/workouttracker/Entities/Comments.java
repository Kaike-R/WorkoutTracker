package br.com.kaikedev.workouttracker.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private Users user;

    @JoinColumn(nullable = false, name = "workout_id")
    @ManyToOne
    @JsonBackReference
    //@JsonIgnore
    private Workout workout;

}
