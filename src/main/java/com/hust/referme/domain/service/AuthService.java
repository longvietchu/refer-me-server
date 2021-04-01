package com.hust.referme.domain.service;

import com.hust.referme.app.dto.LoginDto;
import com.hust.referme.app.dto.RegisterDto;
import com.hust.referme.domain.entity.User;
import com.hust.referme.domain.exception.BadRequestException;
import com.hust.referme.domain.exception.Message;
import com.hust.referme.domain.repository.UserRepository;
import com.hust.referme.domain.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AuthService extends BaseService {

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseEntity<?> register(RegisterDto registerDto) {
        User user = validFormatEmail(registerDto.getEmail());
        if(Objects.nonNull(user)) {
            throw new BadRequestException(Message.USERNAME_EXISTED);
        }
        User userSaved = savedUser(registerDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<?> login(LoginDto loginDto) {

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    private User savedUser(RegisterDto registerDto) {
        User user = new User();
        String passwordEncode = encodePassword(registerDto.getPassword());
        user.assignFormRegister(registerDto.getName(), registerDto.getEmail(), passwordEncode);
        return userRepository.save(user);
    }

    private User validFormatEmail(String email) {
        User user;
        if(Helpers.regexEmail(email)) {
            user = userRepository.findUsersByEmail(email);
        } else {
            throw new BadRequestException(Message.WRONG_FORMAT);
        }
        return user;
    }
}
