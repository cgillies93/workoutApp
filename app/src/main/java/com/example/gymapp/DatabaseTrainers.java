package com.example.gymapp;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTrainers {
    private List<Trainer> trainers = new ArrayList<>();

    public DatabaseTrainers(){
        trainers.add(new Trainer("Chuck","Norris","Certified Ass-Kicker",
                "Biography information will go here"));
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }
}
