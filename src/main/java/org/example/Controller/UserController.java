package org.example.Controller;

import org.example.Model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserController {
    private List<User> users;

    public UserController(List<User> users) {
        this.users = users;
    }
    public Optional<User> getUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public void addUser(User user) {
        // before adding, we can check if user with this username already exists
        if (getUser(user.getUsername()).isEmpty()) {
            this.users.add(user);
            // Writing the new user to a file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
            bw.write(user.getUsername());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        } else {
            System.out.println("User with this username already exists.");
        }
    }

    public List<User> getAllUsers() {
        return users;
    }
}

