package com.coductivity.Coductivity.controller;

import java.util.List;
import java.util.Optional;

import com.coductivity.Coductivity.model.User;
import com.coductivity.Coductivity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coductivity")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint for GET requests - Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint for GET request - Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserByID(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint for POST request - Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser); // 201 Created status
    }

    // Endpoint for PUT request - Update an existing user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = userService.getUserByID(id);
        if (existingUser.isPresent()) {
            user.setUserID(id); // Ensure the user ID is set for update
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser); // Return updated user
        } else {
            return ResponseEntity.notFound().build(); // If user doesn't exist
        }
    }

    // Endpoint for DELETE request - Delete a user by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> existingUser = userService.getUserByID(id);
        if (existingUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); // 204 No Content (successfully deleted)
        } else {
            return ResponseEntity.notFound().build(); // If user doesn't exist
        }
    }
}
