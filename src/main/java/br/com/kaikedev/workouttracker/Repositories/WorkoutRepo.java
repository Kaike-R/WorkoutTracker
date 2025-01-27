package br.com.kaikedev.workouttracker.Repositories;

import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Entities.Workout;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

    List<Workout> findWorkoutByUser(Users user);

    @Transactional
    @Modifying
    @Query(value = "insert into workout_exercises (workout_id, exercise) values (:workoutId, :exercise)", nativeQuery = true)
    void addExercise(@Param("workoutId") Integer workoutId ,@Param("exercise") String exercise);

    //String insertCommentsById(int id);

}
