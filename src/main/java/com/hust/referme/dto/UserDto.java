package com.hust.referme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import java.time.LocalDateTime;

public class UserDto {

    @NotNull
    private String name;
    @NotNull
    private String email;

    private LocalDateTime dob;
    private String avatar;
    private String backgroundImage;
    private String about;
    private int gender;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    public UserDto() {
    }

    public UserDto(String name, String email, LocalDateTime dob, String avatar, String backgroundImage, String about, int gender) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.avatar = avatar;
        this.backgroundImage = backgroundImage;
        this.about = about;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
