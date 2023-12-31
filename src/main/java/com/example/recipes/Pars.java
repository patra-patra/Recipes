package com.example.recipes;
import javafx.scene.Parent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pars {
    public Recipe GetRecipe(String path) throws IOException{

        Recipe temp_ = new Recipe();
        Document doc1 = Jsoup.connect(path).get();

        temp_.name = NameRecipe(doc1);
        temp_.main_img = GetMainImg(doc1);
        temp_.time = Time(doc1);
        temp_.steps = Steps(doc1);
        temp_.category = Category(doc1);

        return temp_;
    }
    private String NameRecipe(Document doc1) throws IOException {
        String title_dish = doc1.select("h1").text();

        return title_dish;
    }
    private String Time(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("time_cook");
        String time = text2.text();

        return time;
    }
    public ArrayList<String> Ingridients(String link) throws IOException {
        Document doc1 = Jsoup.connect(link).get();

        Elements text2 = doc1.getElementsByClass("ingredients");
        String pre_ingr = text2.text();

        pre_ingr = pre_ingr.substring(0, pre_ingr.length() - 1);
        String[] ingredients;
        ArrayList<String> ingredients_fin = new ArrayList<>();

        ingredients = pre_ingr.split(", ");

        //Product[] products = new Product[ingredients.length];

        for (int i = 0; i < ingredients.length; i++){
            ingredients_fin.add(ingredients[i]);
        }

        //return ingredients;
        return ingredients_fin;
    }
    private ArrayList<Step> Steps(Document doc1) throws IOException {
        Elements text23 = doc1.select("ol");

        Step[] steps = new Step[0];

        for (Element a : text23) {
            steps = new Step[a.children().size()];

            for (int i = 0; i < a.children().size(); i++) {
                String t;
                Step step = new Step();
                ArrayList<String> list_img = new ArrayList<>();
                if (a.child(i).tagName() == "p"){
                    t = a.child(i).child(0).attr("href");
                    list_img.add("https://saechka.ru" + t);
                    steps[i-1].img = list_img;

                }
                if (a.child(i).tagName() != "p") {
                    t = a.child(i).text();
                    step.text = t;
                }
                steps[i] = step;

            }
        }

        ArrayList<Step> steps_fin = new ArrayList<>();

        for (Step s : steps) {
            if (s.text != null){
                steps_fin.add(s);
            }
        }


        return steps_fin;
    }
    private String Category(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("cat_razd");
        String cat = text2.text();

        return cat;
    }

    private String GetMainImg(Document doc1){
        Elements meta = doc1.select("meta[property=og:image]");
        String path_img = "";
        for (Element s : meta) {
            path_img = s.attr("content");
        }
        return path_img;
    }
    private void DownloadImg(String path, String name) throws IOException {

        String file = name+".jpg";

        URL img = new URL (path);
        InputStream is = img.openStream();
        OutputStream os = new FileOutputStream(file);
        byte[] b = new byte[2048];
        int lenght;
        while ((lenght = is.read(b)) != -1){
            os.write(b, 0, lenght);
        }
        is.close();
        os.close();
    }
}