package com.example.recipes;

import java.util.Comparator;
public class CompByName implements Comparator<Recipe> {
    @Override
    public int compare(Recipe o1, Recipe o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}