package br.com.kaikedev.workouttracker.Services;


import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    public UserRepo userRepo;


    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    public Users findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Users alterUser(Users user) {
        return user;
    }

    public void deleteUser(String user) {
        System.out.println("Deleting user: " + user);
    }
}
