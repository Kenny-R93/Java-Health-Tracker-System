package org.example.Controller;

import org.example.Model.Diet;
import org.example.Model.Exercise;
import org.example.Model.SleepRecord;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HealthDataController {
    private List<Diet> foodItems;
    private List<Exercise> exercises;
    private List<SleepRecord> sleepRecords;

    public HealthDataController(List<Diet> foodItems, List<Exercise> exercises, List<SleepRecord> sleepRecords) {
        this.foodItems = foodItems;
        this.exercises = exercises;
        this.sleepRecords = sleepRecords;
    }

    public void saveDiet(Diet dietList) {
        this.foodItems.add(dietList);
        Diet diet2 = new Diet("Apple", 95);
        String name = diet2.getName();
        int calories = diet2.getCalories();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Diet.txt", true))) {
            bw.write(diet2.getName() + "," + diet2.getCalories());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void loadDiet () {
        try (BufferedReader br = new BufferedReader(new FileReader("Diet.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int calories = Integer.parseInt(parts[1]);
                this.foodItems.add(new Diet(name, calories));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void saveExercise(Exercise exercise) {
        this.exercises.add(exercise);

        // Writing the new exercise to a file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Exercises.txt", true))) {
            bw.write(exercise.getType() + "," + exercise.getDuration() + "," + exercise.getCaloriesBurned());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void loadExercises() {
        try (BufferedReader br = new BufferedReader(new FileReader("exercises.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int duration = Integer.parseInt(parts[1]);
                int caloriesBurned = Integer.parseInt(parts[2]);
                this.exercises.add(new Exercise(type, duration, caloriesBurned));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public void SaveSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecords.add(sleepRecord);

        // Create a DateTimeFormatter to format the LocalDateTime objects
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Writing the new sleep record to a file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("SleepRecords.txt", true))) {
            bw.write(sleepRecord.getSleepTime().format(formatter) + "," +
                    sleepRecord.getWakeTime().format(formatter));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void loadSleepRecords() {
        // Create a DateTimeFormatter to parse the LocalDateTime objects
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader("sleeprecords.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDateTime startTime = LocalDateTime.parse(parts[0], formatter);
                LocalDateTime endTime = LocalDateTime.parse(parts[1], formatter);
                this.sleepRecords.add(new SleepRecord(startTime, endTime));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public List<Diet> getAllFoodItems() {
        return foodItems;
    }

    public List<Exercise> getAllExercises() {
        return exercises;
    }

    public List<SleepRecord> getAllSleepRecords() {
        return sleepRecords;
    }
}