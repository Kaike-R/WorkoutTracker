package br.com.kaikedev.workouttracker.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkoutRequest {

    private String title;

    private String description;

    private LocalDateTime appointment;

    private List<String> exercises;

    private Users user;

}
