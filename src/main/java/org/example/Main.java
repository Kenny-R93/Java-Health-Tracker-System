package org.example;


import org.example.Controller.HealthDataController;
import org.example.Controller.UserController;
import org.example.Model.Diet;
import org.example.Model.Exercise;
import org.example.Model.SleepRecord;
import org.example.Model.User;
import org.example.View.HealthTrackerView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create the model, view, and controller instances
        List<User> users = new ArrayList<>();
        UserController userController = new UserController(users);

        List<Diet> foodItems = new ArrayList<>();
        List<Exercise> exercises = new ArrayList<>();
        List<SleepRecord> sleepRecords = new ArrayList<>();
        HealthDataController healthDataController = new HealthDataController(foodItems, exercises, sleepRecords);

        HealthTrackerView view = new HealthTrackerView();

        // Run the application
        while (true) {
            view.displayMenu();
            int choice = view.getUserInput();
            switch (choice) {
                case 1: // Add user
                    User user = view.getUserDetails();
                    userController.addUser(user);
                    break;
                case 2: // Add Foods

                case 3: // Add Exercise
                case 4: // Add Sleep Record
                case 5: // Daily Caloric Balance
                case 6: // Sleep Analysis
                case 7: // Exercise Log
                case 8: // Health Summary
                // Other cases to handle other menu options...
                case 0: // Exit
                    System.exit(0);
                }
            }
        }
    }