package br.com.kaikedev.workouttracker.Controllers;


import br.com.kaikedev.workouttracker.Entities.UserRequest;
import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Services.UsersServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/v1")
public class UsersController {


    private UsersServices usersServices;

    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping
    public ResponseEntity<String> getUser(@PathVariable String user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody UserRequest user) {
        System.out.println(user);
        return ResponseEntity.ok(usersServices.createUser(user));
    }

    @PatchMapping
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        return ResponseEntity.ok(usersServices.alterUser(user));
    }

    @DeleteMapping("/{email}")
        public ResponseEntity<?> deleteUser(@PathVariable String email) {
        usersServices.deleteUser(email);
        return ResponseEntity.accepted().build();
    }

}
