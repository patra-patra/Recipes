package com.example.recipes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Pars {
    String a = "1";

    public Pars(String name){
        this.a = name;
    }

    public void setDoc() throws IOException {

        Document doc1 = Jsoup.connect("https://saechka.ru/recipes/recipe_yablochnye_chipsy").get();
        String title = doc1.title();
        String title_dish = String.valueOf(doc1.select("h1"));
        //String title = doc1.title();
        System.out.println(title_dish);


    }



}


