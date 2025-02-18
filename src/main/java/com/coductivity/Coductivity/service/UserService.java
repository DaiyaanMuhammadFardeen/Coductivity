package com.coductivity.Coductivity.service;

import com.coductivity.Coductivity.model.User;
import com.coductivity.Coductivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to GET all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to GET a single user
    public Optional<User> getUserByID(Long ID) { return userRepository.findById(ID); }

    // Method to PUT a new user
    public User createUser(User user) { return userRepository.save(user); }

    // Method to POST (Update) an existing user
    public User updateUser(User user) { return userRepository.save(user); }

    // Method to DELETE a user
    public void deleteUser(Long ID) {
        userRepository.deleteById(ID);
    }
}
