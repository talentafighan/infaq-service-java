package com.example.infaqservice.controller;

import com.example.infaqservice.exception.ResourceNotFoundExceotion;
import com.example.infaqservice.model.User;
import com.example.infaqservice.response.CommonResponse;
import com.example.infaqservice.response.CommonResponseGenerator;
import com.example.infaqservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping("/")
    public CommonResponse<List<User>> getAll() {
        List<User> userList = userService.getAll();

        return commonResponseGenerator.successResponse(userList);
    }

    @GetMapping("/{id}")
    public CommonResponse<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundExceotion {
        User getUserById = userService.getUserById(userId);

        return commonResponseGenerator.successResponse(getUserById);
    }

    @PutMapping("/{id}")
    public CommonResponse<User> updateUserById(@PathVariable(value = "id") Long userId, User userDetails) throws ResourceNotFoundExceotion {
        User updateUserById = userService.updateUserById(userId, userDetails);

        return commonResponseGenerator.successResponse(updateUserById);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUserById(@PathVariable(value = "id")Long userId) throws ResourceNotFoundExceotion{
        return userService.deleteUserById(userId);
    }

}
