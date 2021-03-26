package com.hust.referme.app.controller;

import com.hust.referme.domain.service.UserService;
import com.hust.referme.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable (name = "id") String id) {
        Long userId = Long.parseLong(id);
        return ResponseEntity.ok().body(userService.findUserById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }
}