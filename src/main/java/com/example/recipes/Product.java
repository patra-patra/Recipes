package com.example.recipes;

public class Product {
    public String name;
    public double protein;
    public double carbohydrates;
    public double fats;
    public double calories;
    public double temp_weight;

    public Product(){
        name = "empty";
        protein = 0;
        carbohydrates = 0;
        fats = 0;
        calories = 0;
        temp_weight = 0;
    }
    public Product(String _name, Double _protein, Double _carb, Double _fats, Double _calories, Double _temp_weight){
        name = _name;
        protein = _protein;
        carbohydrates = _carb;
        fats = _fats;
        calories = _calories;
        temp_weight = _temp_weight;
    }



}
