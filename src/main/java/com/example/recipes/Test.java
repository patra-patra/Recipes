package com.example.recipes;
import java.util.List;
public class Test {
    public static void main(String[] args) {


        List<Recipe> recipes = Database.showAllRecipe();
        System.out.println(recipes.get(0).name);
        System.out.println(recipes.get(0).id);
        System.out.println(recipes.size());

    }
}
