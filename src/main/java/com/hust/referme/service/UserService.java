package com.hust.referme.service;

import com.hust.referme.dto.UserDto;
import com.hust.referme.entity.User;
import com.hust.referme.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User createNewUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        return userRepository.save(user);
    }
}
