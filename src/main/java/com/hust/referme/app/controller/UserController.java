package com.hust.referme.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable (name = "id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        return userService.findAll();
    }
}
