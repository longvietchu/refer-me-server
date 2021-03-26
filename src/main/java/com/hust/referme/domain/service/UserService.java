package com.hust.referme.domain.service;

import com.hust.referme.app.response.UserResponse;
import com.hust.referme.domain.entity.User;
import com.hust.referme.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user -> mapper.map(user, UserResponse.class)).collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }

    public ResponseEntity<?> createNewUser(User user) {
        userRepository.save(user);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<?> findUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        return ResponseEntity.ok(userResponse);
    }
}
