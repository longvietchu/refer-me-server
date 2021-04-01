package com.hust.referme.app.controller;

import com.hust.referme.domain.service.AuthService;
import com.hust.referme.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired protected AuthService authService;
    @Autowired protected UserService userService;
}
