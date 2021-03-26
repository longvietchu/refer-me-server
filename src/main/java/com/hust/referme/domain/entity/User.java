package com.hust.referme.domain.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private LocalDateTime dob;
    private String avatar;
    @Column(name = "background_image")
    private String backgroundImage;
    private String about;
    private int gender;
    @Column(name = "created_at")
    @CreatedDate
    @NotNull
    private final LocalDateTime createdAt = LocalDateTime.now();
}
