package com.example.recipes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Pars {
    private Recipe GetRecipe(String path) throws IOException{
        Recipe temp_ = new Recipe();

        Document doc1 = Jsoup.connect(path).get();

        //String title_dish = doc1.select("h1").text();
        // String time = text2.text();
        //Elements text3 = doc1.getElementsByClass("nutrition_nutrition");
        //String nutrition = text3.text();
        //Elements text5 = doc1.getElementsByClass("cook");
        //String tips = text5.text();
        //Elements text6 = doc1.getElementsByClass("cat_some");
        //String cat = text2.text();

        temp_.name = doc1.select("h1").text();
        temp_.time = doc1.getElementsByClass("time_cook").text();

        Elements text4 = doc1.getElementsByClass("ingredients");
        String nutrition2 = text4.text();

        //temp_.tips = doc1.getElementsByClass("cook").text();
        //temp_.category = doc1.getElementsByClass("cat_some").text();

        return temp_;
    }
    public void NameRecipe(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        String title_dish = doc1.select("h1").text();

        System.out.println(title_dish);
    }
    public void Time(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("time_cook");
        String time = text2.text();

        System.out.println(time);
    }
    public void Nutrition(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("nutrition_nutrition");
        String nutrition = text2.text();

        System.out.println(nutrition);
    }
    public void Ingridients(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("ingredients");
        String nutrition = text2.text();

        System.out.println(nutrition);
    }
    public void Steps(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("cook");
        Elements ol = doc1.getElementsByTag("ol");
        
        String s = doc1.select("h2").text();
        //Elements aaa = doc1.select("li");


        Elements text = doc1.select("cook");

        //String tips = text2.text();
        for (Element a: ol){
            System.out.println(a + "\n\n\n");
        }


       //System.out.println(s);
    }
    public void Category(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("cat_some");
        String nutrition = text2.text();

        System.out.println(nutrition);
    }

}
