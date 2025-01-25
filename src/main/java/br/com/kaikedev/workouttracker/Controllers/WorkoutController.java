package br.com.kaikedev.workouttracker.Controllers;


import br.com.kaikedev.workouttracker.Entities.Workout;
import br.com.kaikedev.workouttracker.Entities.WorkoutResponse;
import br.com.kaikedev.workouttracker.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout/v1")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;


    @GetMapping
    public ResponseEntity<List<WorkoutResponse>> returnAll() {
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @PostMapping
    public ResponseEntity<String> addComments(@RequestBody Integer workoutId) {
        return ResponseEntity.ok("Hello");
    }

}
