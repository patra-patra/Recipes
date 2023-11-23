package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Recipe {
    Integer id;
    String name;
    ArrayList<String> category;
    String main_img;
    String time;
    String difficulty_level;
    Product products;
    String favorite;
    ArrayList<Step> steps;


    public Recipe() {

        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        difficulty_level = "empty";
        products = new Product();
        favorite = "empty";
    }

    public Recipe(String _name, String _category, String _time, String _di) {
        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        difficulty_level = "empty";
        products = new Product();
        favorite = "empty";
    }

    private void GetAll(){

    }
    private void Change(){

    }

}
