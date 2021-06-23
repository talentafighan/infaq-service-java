package com.example.infaqservice.service;

import com.example.infaqservice.exception.ResourceNotFoundExceotion;
import com.example.infaqservice.model.User;

import java.util.List;
import java.util.Map;

public interface UserImpl {
    List<User> getAll();

    User getUserById(Long userId) throws ResourceNotFoundExceotion;

    User updateUserById(Long userId, User userDetails) throws ResourceNotFoundExceotion;

    Map<String, Boolean> deleteUserById(Long userId) throws ResourceNotFoundExceotion;

    User register(User userRequire) throws ResourceNotFoundExceotion;

    User login(User userRequire) throws ResourceNotFoundExceotion;
}
