package com.example.recipes;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Product> shopping_bag;
    public static List<String> all_recipe;

    public static Recipe current_recipe;
    public static List<Step_img> current_recipe_img;

    public static ArrayList<String> ingredients_from_pars;


    public Data() {
        current_recipe = new Recipe();
        all_recipe = Get();
        ingredients_from_pars = new ArrayList<>();
        shopping_bag= new ArrayList<>();
        current_recipe_img = new ArrayList<>();
    }
    public static List<String> Get(){
        List<Recipe> recipes = Database.showAllRecipe();

        List<String> strings = new ArrayList<>();

        for (Recipe y : recipes){
            strings.add(y.name);
        }

        return strings;
    }
    public static List<String> Get_cart(){
        List<Recipe> recipes = Database.showRecipeFavorite();

        List<String> strings = new ArrayList<>();

        for (Recipe y : recipes){
            strings.add(y.name);
        }

        return strings;
    }


}
