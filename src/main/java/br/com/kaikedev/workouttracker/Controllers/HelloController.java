package br.com.kaikedev.workouttracker.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello/v1")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<String> helloPost(@PathVariable String name) {
        return ResponseEntity.ok("Hello World" + name);
    }


}
