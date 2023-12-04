package com.example.recipes;


import java.util.ArrayList;

public class Recipe {
    public Integer id;
    public String name;
    public String category;
    public String main_img;
    public String time;
    public String difficulty_level;
    public Integer favorite;
    public ArrayList<String> Ingr;
    public ArrayList<Step> steps;



    @Override
    public String toString() {;
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", main_img='" + main_img + '\'' +
                ", time='" + time + '\'' +
                ", difficulty_level='" + difficulty_level + '\'' +
                ", favorite=" + favorite +
                '}';
    }

    public Recipe(int rec_id, int step_id, String text) {
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
    public Recipe(Integer id, String name, String category, String main_img, String time, String difficulty_level,
                  Integer favorite) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.main_img = main_img;
        this.time = time;
        this.difficulty_level = difficulty_level;
        this.favorite = favorite;
    }
    public Recipe() {
        id = 0;
        name = "empty";
        category = "empty";
        main_img = "empty";
        time = "empty";
        difficulty_level = "empty";
        //favorite = "empty";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }
}
