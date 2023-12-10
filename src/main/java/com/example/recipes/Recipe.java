package com.example.recipes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recipe {
    public Integer id;
    public String name;
    public String category;
    public String main_img;
    public String time;
    public String difficulty_level;
    public Integer favorite;

    public List<Step> steps;
    public List<Product> ingredients;

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
    public Recipe() {
        id = 0;
        name = "";
        category = "";
        main_img = "";
        time = "";
        difficulty_level = "";
        favorite = 0;
        steps = new ArrayList<>();
        ingredients = new ArrayList<>();
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



    public Double[] Count_p_c_f_cl (List<Product> Ingr){
        Double[] p_c_f_cl = {0.0, 0.0, 0.0, 0.0};

        ArrayList<Product> f = new ArrayList<>(Ingr);
/*
        List<Product> i = new ArrayList<>();

        i.add(Database.searchProduct("Картофель"));

        i.add(Database.searchProduct("Картофель"));

        for (Product p: i){
            System.out.println(p);
        }
*/

        //Database.deleteRecipe(1);
        f.add(Database.searchProduct("Картофель"));
        for (Product ing: Ingr) {
            p_c_f_cl[0] += 1000/100 * ing.protein;
            p_c_f_cl[1] += 1000/100 * ing.carbohydrates;
            p_c_f_cl[2] += 1000/100 * ing.fats;
            p_c_f_cl[3] += 1000/100 * ing.calories;
        }

        return p_c_f_cl;
    }

    public int compareTo(Recipe o) {
        return name.compareTo(o.name);
    }
    public String getName() {
        return name;
    }
    public static final Comparator<Recipe> COMPARE_BY_COUNT = new Comparator<Recipe>() {

        public int compare(Recipe lhs, Recipe rhs) {
            return lhs.getCount() - rhs.getCount();
        }
    };
    private int getCount() {
        return 0;
    }

}
