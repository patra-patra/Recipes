package com.example.recipes;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static ArrayList<Product> shopping_bag;
    public static List<String> all_recipe;

    public static Recipe current_recipe;

    public static ArrayList<String> ingredients_from_pars;


    public Data() {
        current_recipe = new Recipe();
        all_recipe = Get();
        ingredients_from_pars = new ArrayList<>();
        shopping_bag= new ArrayList<>();
    }
    public static List<String> Get(){
        List<Recipe> recipes = Database.showAllRecipe();

        List<String> strings = new ArrayList<>();

        for (Recipe y : recipes){
            strings.add(y.name);
        }

        return strings;
    }


}
