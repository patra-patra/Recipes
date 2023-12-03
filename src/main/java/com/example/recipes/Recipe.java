package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//import static org.graalvm.compiler.debug.DebugOptions.Log;

public class Recipe {
    //Integer id;
    String name;
    String category;
    String main_img;
    String time;
    //String difficulty_level;
    Product products;
    ArrayList<String> Ingr;
    //String favorite;
    public ArrayList<Step> steps;

    public Recipe() {
        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        //difficulty_level = "empty";
        products = new Product();
        //favorite = "empty";
    }

    public Recipe(String _name, String _category, String _time, String _di) {
        name = "empty";
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        //difficulty_level = "empty";
        products = new Product();
        //favorite = "empty";
    }
    public Recipe(String _name) {
        name = _name;
        //category = "empty";
        //main_img = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPm4OafJsXDQRBuPD3DlTaf64EYDyx_mA-sQ&usqp=CAU");
        time = "empty";
        //difficulty_level = "empty";
        products = new Product();
        //favorite = "empty";
    }

    private void GetAll(){

    }
    private void Change(){

    }



    public int compareTo(Recipe o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }
/*
    public double getAvgMark() {
        return avgMark;
    }

*/
    private ArrayList<String> SortByAlphabet(ArrayList<String> arr){

        Collections.sort(arr);
        return arr;
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

    public ArrayList<Recipe> SortByAlphabet_rec(ArrayList<Recipe> arr){

        //Collections.sort(arr);


        ArrayList<Recipe> songs = new ArrayList<>();
        songs.add(new Recipe("z"));
        songs.add(new Recipe("f"));
        songs.add(new Recipe("a"));
        songs.add(new Recipe("w"));


        Collections.sort(songs, Recipe.COMPARE_BY_COUNT);

        for (Recipe A: songs){
            System.out.println(A.name);
        }
        return arr;
    }

}

