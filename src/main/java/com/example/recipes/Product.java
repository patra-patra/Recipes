package com.example.recipes;
import java.util.*;

public class Product {
    int id;
    public String name;
    public double protein;
    public double carbohydrates;
    public double fats;
    public double calories;
    public double temp_weight;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", calories=" + calories +
                ", temp_weight=" + temp_weight +
                '}';
    }

    public Product() {
    }

    public Product(int id, String name, double protein, double carbohydrates, double fats, double calories,
                   double temp_weight) {
        this.id = id;
        this.name = name;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
        this.temp_weight = temp_weight;
    }

    public double getTemp_weight() {
        return temp_weight;
    }

    public void setTemp_weight(double temp_weight) {
        this.temp_weight = temp_weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
