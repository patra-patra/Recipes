package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

    }
    public static void main( String[] args ) throws IOException{
        Pars pars = new Pars();
        String path = "https://saechka.ru/recipes/recipe_sloenye_morkovki";//"https://saechka.ru/recipes/recipe_pryaniki_dlya_rospisi_morkovki";//"https://saechka.ru/recipes/recipe_5163";//= "https://saechka.ru/recipes/recipe_sloenye_morkovki";
        //String path = "https://saechka.ru/recipes/recipe_blinnyy_tort_s_makom";

        Recipe a = new Recipe();
        Document doc1 = Jsoup.connect(path).get();
        pars.Steps(doc1);

        /*
        URL img = new URL ("https://saechka.ru/upload/iblock/884/001.jpg");
        InputStream is = img.openStream();
        OutputStream os = new FileOutputStream(file);
        byte[] b = new byte[2048];
        int lenght;
        while ((lenght = is.read(b)) != -1){
            os.write(b, 0, lenght);
        }
        is.close();
        os.close();
*/
    }
}