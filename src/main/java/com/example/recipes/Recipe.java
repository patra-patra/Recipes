package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Recipe {
    //Integer id;
    String name;
    String category;
    String main_img;
    String time;
    String difficulty_level;
    ArrayList<String> Ingr;
    //String favorite;
    public ArrayList<Step> steps;

    public Recipe() {
        name = "empty";
        category = "empty";
        main_img = "empty";
        time = "empty";
        difficulty_level = "empty";
        //favorite = "empty";
    }
    public Double[] Count_p_c_f_cl (ArrayList<Product> Ingr){
        Double[] p_c_f_cl = {0.0, 0.0, 0.0, 0.0};


        for (Product ing: Ingr) {
            p_c_f_cl[0] += ing.temp_weight/100 * ing.protein;
            p_c_f_cl[1] += ing.temp_weight/100 * ing.carbohydrates;
            p_c_f_cl[2] += ing.temp_weight/100 * ing.fats;
            p_c_f_cl[3] += ing.temp_weight/100 * ing.calories;
        }

        return p_c_f_cl;
    }
    private Double GetWeight(String j){
        return 0.0;
    }
    private ArrayList<Recipe> GetAll(){
        ArrayList<Recipe> all = new ArrayList<>();
        return all;
    }
    private void Change(String _name, Recipe recipe){
        recipe.name = _name;
    }
    public int compareTo(Recipe o) {
        return name.compareTo(o.name);
    }
    public String getName() {
        return name;
    }
    public static final Comparator<Recipe> COMPARE_BY_COUNT = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe lhs, Recipe rhs) {
            return lhs.getCount() - rhs.getCount();
        }
    };
    private int getCount() {
        return 0;
    }
}

