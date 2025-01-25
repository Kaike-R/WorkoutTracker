package br.com.kaikedev.workouttracker.Repositories;

import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

    List<Workout> findWorkoutByUser(Users user);

    //String insertCommentsById(int id);

}
