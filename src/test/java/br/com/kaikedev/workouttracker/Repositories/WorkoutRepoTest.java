package br.com.kaikedev.workouttracker.Repositories;

import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Entities.Workout;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class WorkoutRepoTest {

    @Autowired
    WorkoutRepo workoutRepo;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Should get Workout Succefully")
    void findWorkoutByUserSuccess() {
        Users user = new Users(1, "Test", "Test@test.com", "123456", LocalDateTime.now(), LocalDateTime.now());
        Workout workout = new Workout(1, "TestWorkout","TestWorkout", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(), null, null, user);
        List<Workout> workouts = List.of(workout);
        user.setWorkout(workouts);
//        em.clear();
        Users x = createUser(user);
        Workout y = createWorkout(workout);
//
        List<Workout> result = this.workoutRepo.findWorkoutByUser(user);
//
        assertThat(result).hasSize(1);
//        assertThat(true).isTrue();
    }

    @Transactional
    protected Users createUser(Users users) {
        this.em.merge(users);
        return users;
    }

    private Workout createWorkout(Workout workout) {
        this.em.merge(workout);
        return workout;
    }
}