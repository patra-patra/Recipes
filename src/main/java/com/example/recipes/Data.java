package com.example.recipes;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static ArrayList<String> favorite;
    public static ArrayList<String> shopping_bag;
    //public static List<String> all_recipe;
    public static List<String> all_recipe = Get();


    public  static List<Step> steps_from_new = new ArrayList<>();
    public  static String name_from_new;
    public  static String category_from_new;


    public static Recipe parsed_recipe;
    public static Recipe current_recipe;




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
    public static void AddToTempSteps(Step step){
        steps_from_new.add(step);
        //all_recipe = Get();
    }

}
