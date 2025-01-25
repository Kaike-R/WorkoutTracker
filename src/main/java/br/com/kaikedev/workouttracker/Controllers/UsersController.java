package br.com.kaikedev.workouttracker.Controllers;


import br.com.kaikedev.workouttracker.Entities.Users;
import br.com.kaikedev.workouttracker.Services.UsersServices;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/v1")
public class UsersController {

    private UsersServices usersServices;

    @GetMapping
    public ResponseEntity<String> getUser(@PathVariable String user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        System.out.println(user);
        return ResponseEntity.ok(usersServices.createUser(user));
    }

    @PatchMapping
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        return ResponseEntity.ok(usersServices.alterUser(user));
    }

    @DeleteMapping
    public ResponseEntity<Users> deleteUser(@PathVariable String user) {
        usersServices.deleteUser(user);
        return ResponseEntity.accepted().build();
    }

}
