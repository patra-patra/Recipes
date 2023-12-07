package com.example.recipes;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static ArrayList<String> shopping_bag;
    public static List<String> all_recipe = Get();


    public static Recipe current_recipe;

    public static String mediator_to_recipe;


    public static List<String> Get(){
        List<Recipe> recipes = Database.showAllRecipe();

        List<String> strings = new ArrayList<>();

        for (Recipe y : recipes){
            strings.add(y.name);
        }

        return strings;
    }



    public static void AddToShoppingBag(String recipe){
        shopping_bag.add(recipe);
        all_recipe = Get();
    }


}
