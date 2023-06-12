package org.example.Controller;

import org.example.Model.User;

import java.util.List;
import java.util.Optional;

public class UserController {
    private List<User> users;

    public UserController(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        // before adding, we can check if user with this username already exists
        if (getUser(user.getUsername()).isEmpty()) {
            this.users.add(user);
            // TODO: add code to persist the new user (write to file)
        } else {
            System.out.println("User with this username already exists.");
        }
    }

    public Optional<User> getUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public List<User> getAllUsers() {
        return users;
    }
}

