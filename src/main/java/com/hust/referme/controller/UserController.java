package com.hust.referme.controller;

import com.hust.referme.dto.UserDto;
import com.hust.referme.entity.User;
import com.hust.referme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/{userId}")
//    public ResponseEntity<?> getUser(@PathVariable (name = "userId") Integer userId) {
//        return ResponseEntity.ok().body();
//    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }
}
