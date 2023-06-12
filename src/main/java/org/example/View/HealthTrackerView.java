package org.example.View;

import org.example.Model.Diet;
import org.example.Model.User;

import java.util.Scanner;

public class HealthTrackerView {
    private Scanner scanner;

    public HealthTrackerView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add user");
        System.out.println("2. Add food item");
        System.out.println("3. Add exercise");
        System.out.println("4. Add sleep record");
        System.out.println("0. Exit");
    }

    public int getUserInput() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return choice;
    }

    public User getUserDetails() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        return new User(username);
    }

    public Diet getFoodItemDetails() {
        System.out.print("Enter food name: ");
        String name = scanner.nextLine();
        System.out.print("Enter calories: ");
        int calories = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return new Diet(name, calories);
    }
}