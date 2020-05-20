package com.samoylenko.homework131;

import java.sql.Time;
import java.util.Date;

public class Indicator {
    private User user;
    private double weight;
    private int steps;
    private Date dateIndicator;

    public Indicator() {
    }

    public Indicator(User user, double weight, int steps, Date timeIndicator) {
        this.user = user;
        this.weight = weight;
        this.steps = steps;
        this.dateIndicator = timeIndicator;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Date getDateIndicator() {
        return dateIndicator;
    }

    public void setDateIndicator(Date dateIndicator) {
        this.dateIndicator = dateIndicator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
