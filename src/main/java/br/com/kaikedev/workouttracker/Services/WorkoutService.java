package br.com.kaikedev.workouttracker.Services;

import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Entities.Workout;
import br.com.kaikedev.workouttracker.Entities.WorkoutResponse;
import br.com.kaikedev.workouttracker.Repositories.WorkoutRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    public WorkoutRepo workoutRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Workout createWorkout(Workout workout) {
        return workoutRepo.save(workout);
    }

    public List<WorkoutResponse> getAllWorkouts() {

        List<Workout> x = workoutRepo.findAll();

        System.out.println(x.getFirst().getComments().getFirst().getContent());

//        TypeMap<Workout, WorkoutResponse> propertyMapping = this.modelMapper.createTypeMap(Workout.class, WorkoutResponse.class);
//        propertyMapping.addMappings(mapper -> mapper.map(src -> src.getComments() != null ?
//                src.getComments().stream().map(Comments::getContent).toList() : List.of(), WorkoutResponse::setComments));


        return modelMapper.map(x, new TypeToken<List<WorkoutResponse>>() {
        }.getType());
    }

//    public List<Workout> getAllWorkouts() {
//        List<Workout> x = workoutRepo.findAll();
//        return x;
//    }

    public List<Workout> getAllWorkoutsWithUserId(Users user) {
        return workoutRepo.findWorkoutByUser(user);
    }

    public Workout updateWorkout(Workout workout) {
        return workoutRepo.save(workout);
    }

    public void deleteWorkout(Workout workout) {
        workoutRepo.delete(workout);
    }

//    public String insertCommentsById(int id) throws Exception{
//        return workoutRepo.insertCommentsById(id);
//    }

//    public Workout updateComments(String comments) {
//
//    }

    public void addExercise(Integer workoutId, List<String> exercises) {

        for (String exercise : exercises) {
            System.out.println(workoutId + " " + exercise);
            workoutRepo.addExercise(workoutId,exercise);
        }

        //workoutRepo.addExercise(exercises.getFirst());

    }

    public void removeExercise(Integer workoutId, String exercise) {

        workoutRepo.deleteExercise(workoutId,exercise);
    }

}
