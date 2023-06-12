package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Diet> dietList;
    private List<Exercise> exercises;
    private List<SleepRecord> sleepRecords;

    public User(String username) {
        this.username = username;
        this.dietList = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.sleepRecords = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Diet> getDietList() {
        return dietList;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public List<SleepRecord> getSleepRecords() {
        return sleepRecords;
    }

    public void addDiet(Diet dietList) {
        this.dietList.add(dietList);
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public void addSleepRecord(SleepRecord sleepRecord) {
        this.sleepRecords.add(sleepRecord);
    }

}


