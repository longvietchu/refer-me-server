package com.hust.referme.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
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
    @CreationTimestamp
    @NotNull
    private final LocalDateTime createdAt = LocalDateTime.now();

    public void assignFormRegister(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }
}
