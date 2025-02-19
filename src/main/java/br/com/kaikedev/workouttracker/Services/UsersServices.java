package br.com.kaikedev.workouttracker.Services;


import br.com.kaikedev.workouttracker.Entities.UserRequest;
import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    public UserRepo userRepo;

    public Users getUser(Integer id) {
        return userRepo.findById(id).get();
    }


    public Users createUser(UserRequest user) {

        Users users = new Users(user.getName(), user.getEmail(), user.getPassword());
        System.out.println("Aqui");
        return userRepo.save(users);
    }

    public Users findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //TODO fazer fluxo de alterar
    public Users alterUser(Users user) {
        return user;
    }

    public void deleteUser(String email) {
        Users user = findUserByEmail(email);
        System.out.println("Deleting user: " + user);
        userRepo.delete(user);
    }
}
