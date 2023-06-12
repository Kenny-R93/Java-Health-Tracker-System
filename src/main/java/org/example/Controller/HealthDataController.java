package org.example.Controller;

import org.example.Model.Diet;
import org.example.Model.Exercise;
import org.example.Model.SleepRecord;

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

    public void addFoodItem(Diet dietList) {
        this.foodItems.add(dietList);
        // TODO: add code to persist the new food item (write to file)
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
        // TODO: add code to persist the new exercise (write to file)
    }

    public void addSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecords.add(sleepRecord);
        // TODO: add code to persist the new sleep record (write to file)
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