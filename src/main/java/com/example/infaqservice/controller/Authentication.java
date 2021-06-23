package com.example.infaqservice.controller;

import com.example.infaqservice.exception.ResourceNotFoundExceotion;
import com.example.infaqservice.model.User;
import com.example.infaqservice.response.CommonResponse;
import com.example.infaqservice.response.CommonResponseGenerator;
import com.example.infaqservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Authentication {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @PostMapping("/login")
    public CommonResponse<User> login(User userRequire) throws ResourceNotFoundExceotion{
        User login = userService.login(userRequire);

        return commonResponseGenerator.successResponse(login);
    }

    @PostMapping("/register")
    public CommonResponse<User> register(User userRequire) throws ResourceNotFoundExceotion{
        User register = userService.register(userRequire);

        return commonResponseGenerator.successResponse(register);
    }

}
