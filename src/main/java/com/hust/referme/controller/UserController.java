package com.hust.referme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable (name = "userId") Integer userId) {
        return ResponseEntity.ok().body();
    }

    public ResponseEntity<?> addUser(@RequestBody )
}
