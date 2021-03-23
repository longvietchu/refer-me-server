package com.hust.referme.service;

import com.hust.referme.dto.CustomUserDetails;
import com.hust.referme.dto.UserDto;
import com.hust.referme.entity.User;
import com.hust.referme.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public UserDto findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(user);
    }
}
