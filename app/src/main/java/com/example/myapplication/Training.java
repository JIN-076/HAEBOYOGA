package com.example.myapplication;

public class Training {

    private String TraingingName;
    private int timeRequired;
    private int CalorieConsumption;
    private String Difficulty;

    public Training(String trainingName, int timeRequired, int CalorieConsumption, String Difficulty) {
        this.TraingingName = trainingName;
        this.timeRequired = timeRequired;
        this.CalorieConsumption = CalorieConsumption;
        this.Difficulty = Difficulty;
    }

    public String getTraingingName() { return TraingingName; }

    public void setTraingingName(String traingingName) { this.TraingingName = traingingName; }

    public int getTimeRequired() { return timeRequired; }

    public void setTimeRequired(int timeRequired) { this.timeRequired = timeRequired; }

    public int getCalorieConsumption() { return CalorieConsumption; }

    public void setCalorieConsumption(int calorieConsumption) { this.CalorieConsumption = calorieConsumption; }

    public String getDifficulty() { return Difficulty; }

    public void setDifficulty(String difficulty) { this.Difficulty = Difficulty; }
}
