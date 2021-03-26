package com.hust.referme.app.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime dob;
    private String avatar;
    private String backgroundImage;
    private String about;
    private int gender;
}
