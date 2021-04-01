package com.hust.referme.app.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @NotNull
    @Size(min = 6, max = 50)
    private String email;

    @NotNull
    @Size(min = 3, max = 50)
    private String password;
}
