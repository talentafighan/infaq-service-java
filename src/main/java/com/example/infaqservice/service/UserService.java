package com.example.infaqservice.service;

import com.example.infaqservice.exception.ResourceNotFoundExceotion;
import com.example.infaqservice.model.User;
import com.example.infaqservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserImpl {

    @Autowired private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) throws ResourceNotFoundExceotion {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExceotion("USER ID NOT FOUND"));
    }

    @Override
    public User updateUserById(Long userId, User userDetails) throws ResourceNotFoundExceotion {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExceotion("USER ID NOT FOUND"));

        user.setEmail(userDetails.getEmail());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setUserType(userDetails.getUserType());
        user.setMobilePhoneNumber(userDetails.getMobilePhoneNumber());
        final User updateUserById = userRepository.save(userDetails);
        return updateUserById;
    }

    @Override
    public Map<String, Boolean> deleteUserById(Long userId) throws ResourceNotFoundExceotion {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExceotion("USER ID NOT FOUND"));

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public User register(User userRequire) throws ResourceNotFoundExceotion {
        User getEmail = userRepository.findByEmail(userRequire.getEmail());
        User getUsername = userRepository.findByUsername(userRequire.getUsername());
        User getMobilePhoneNumber = userRepository.findByMobilePhoneNumber(userRequire.getMobilePhoneNumber());
        if (getEmail == null && getUsername == null && getMobilePhoneNumber == null){
            User newUser = new User();
            newUser.setUsername(userRequire.getUsername());
            newUser.setPassword(userRequire.getPassword());
            newUser.setEmail(userRequire.getEmail());
            newUser.setUserType(userRequire.getUserType());
            newUser.setMobilePhoneNumber(userRequire.getMobilePhoneNumber());
            return userRepository.save(newUser);
        }
        throw new ResourceNotFoundExceotion("USER ALREADY EXIST");
    }

    @Override
    public User login(User userRequire) throws ResourceNotFoundExceotion {
        User user = userRepository.login(userRequire.getUsername(),userRequire.getPassword(),userRequire.getEmail(),userRequire.getMobilePhoneNumber());
        if (user == null){
            throw new ResourceNotFoundExceotion("USER NOT FOUND");
        }
        throw new RuntimeException("LOGIN BERHASIL");
    }
}
