package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

    }
    public static void main( String[] args ) throws IOException{
        Pars pars = new Pars();

        String path = "https://saechka.ru/recipes/recipe_2337";//https://saechka.ru/recipes/recipe_2202";
        String path1 = "https://saechka.ru/recipes/recipe_pryaniki_dlya_rospisi_morkovki";
        String path2 = "https://saechka.ru/recipes/recipe_5163";
        String path3 = "https://saechka.ru/recipes/recipe_sloenye_morkovki";
        String path4 = "https://saechka.ru/recipes/recipe_blinnyy_tort_s_makom";

        Recipe a = new Recipe();

        //a = pars.GetRecipe(path1);

        Document doc1 = Jsoup.connect(path1).get();

        Recipe b, c = null, d = new Recipe();

        Product product = new Product("j", 21.0, 3.0, 5.0, 145.0, 500.0);
        Product product2 = new Product("j", 2.9, 4.8, 2.5, 54.0, 200.0);
        Product product3 = new Product("j", 12.7, 0.7, 11.5, 157.0, 240.0);

        ArrayList<Product> book = new ArrayList<>();



        book.add(product2);
        book.add(product);
        book.add(product3);
        Double[] e = d.Count_p_c_f_cl(book);

        for (Double y : e){
            String result = String.format("%.2f", y);
            System.out.println(result);

        }


       // b = pars.GetRecipe(path4);
       // c = pars.GetRecipe(path2);
        /*
        d = pars.GetRecipe(path);
        for (String g : d.Ingr){
            System.out.println(g);

        }
/*
        ArrayList<Recipe> book = new ArrayList<>();
        book.add(a);
        book.add(b);
        book.add(c);
        book.add(d);

        Collections.sort(book, new CompByName());

*/

    }
}