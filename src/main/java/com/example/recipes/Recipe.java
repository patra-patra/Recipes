package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Recipe {
    Integer id;
    String name;
    String category;
    String main_img;
    String time;
    String difficulty_level;
    Product products;
    Integer favorite;


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
    public Recipe(Integer id, String name, String category, String main_img, String time, String difficulty_level, Integer favorite) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.main_img = main_img;
        this.time = time;
        this.difficulty_level = difficulty_level;
        this.favorite = favorite;
    }

    public Recipe() {

        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        difficulty_level = "empty";
        products = new Product();
        //favorite = "empty";
    }

/*
    public Recipe(String _name, String _category, String _time, String _di) {
        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        difficulty_level = "empty";
        products = new Product();
        favorite = "empty";
    }
*/
    private void GetAll(){

    }
    private void Change(){

    }

}
