package org.example.Model;

public class Exercise {
    private String type;
    private int duration;
    private int caloriesBurned;

    public Exercise(String type, int duration, int caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getType() {
        return this.type;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getCaloriesBurned() {
        return this.caloriesBurned;
    }
}