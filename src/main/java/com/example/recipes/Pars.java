package com.example.recipes;
import javafx.scene.Parent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pars {
    private Recipe GetRecipe(String path) throws IOException{

        Recipe temp_ = new Recipe();
        Document doc1 = Jsoup.connect(path).get();

        temp_.name = NameRecipe(doc1);
        temp_.time = Time(doc1);
        temp_.Ingr = new ArrayList<>(Arrays.asList(Ingridients(doc1)));
        temp_.steps = new ArrayList<>(Arrays.asList(Steps(doc1)));

        return temp_;
    }
    public String NameRecipe(Document doc1) throws IOException {
        String title_dish = doc1.select("h1").text();

        return title_dish;
    }
    public String Time(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("time_cook");
        String time = text2.text();

        return time;
    }
    /*
    public void Nutrition(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("nutrition_nutrition");
        String nutrition = text2.text();

        System.out.println(nutrition);
    }
    */
    public String[] Ingridients(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("ingredients");
        String pre_ingr = text2.text();

        pre_ingr = pre_ingr.substring(0, pre_ingr.length() - 1);
        String[] ingredients;
        ingredients = pre_ingr.split(", ");

        return ingredients;
    }
    public Step[] Steps(Document doc1) throws IOException {
        Elements text23 = doc1.select("ol");

        Step[] steps = new Step[1];

        for (Element a : text23) {
            steps = new Step[a.children().size()];

            for (Integer i = 0; i < a.children().size(); i++) {

                if (a.child(i).text().length() != 0){
                    steps[i].text = a.child(i).text();
                }
                if (a.child(i).tagName() == "p"){
                    steps[i-1].img.add(a.child(i).text());
                }
            }
        }
        return steps;
    }
    public void Category(String path) throws IOException {
        Document doc1 = Jsoup.connect(path).get();
        Elements text2 = doc1.getElementsByClass("cat_some");
        String nutrition = text2.text();

        System.out.println(nutrition);
    }
    private String DifficultyLevel(Integer time, ArrayList<String> steps){
        if (time > 120 || steps.size() > 10){
            return "Высокая";
        }
        else if(30 < time && time < 60 || steps.size() > 5 && steps.size() < 10){
            return "Cредняя";
        }
        else {
            return "Низкая";
        }
    }
}
