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
    public Recipe GetRecipe(String path) throws IOException{

        Recipe temp_ = new Recipe();
        Document doc1 = Jsoup.connect(path).get();

        temp_.name = NameRecipe(doc1);
        temp_.main_img = GetMainImg(doc1);
        temp_.time = Time(doc1);
        temp_.Ingr = new ArrayList<>(Arrays.asList(Ingridients(doc1)));
        temp_.steps = new ArrayList<>(Arrays.asList(Steps(doc1)));
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
    private String[] Ingridients(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("ingredients");
        String pre_ingr = text2.text();

        pre_ingr = pre_ingr.substring(0, pre_ingr.length() - 1);
        String[] ingredients;
        ingredients = pre_ingr.split(", ");

        return ingredients;
    }
    private Step[] Steps(Document doc1) throws IOException {
        Elements text23 = doc1.select("ol");

        Step[] steps = new Step[0];

        for (Element a : text23) {
            steps = new Step[a.children().size()];
            //System.out.println(a.children().size());

            for (int i = 0; i < a.children().size(); i++) {
                String t;
                Step step = new Step();
                if (a.child(i).tagName() == "p"){
                    //steps[i].img.add("path");
                    t = "PATH";

                    //step.img.add("PATH");
                    //steps[i].img.add(t);
                    //System.out.println(t);
                }
                else{
                    //steps[i].text = a.child(i).text();
                    t = a.child(i).text();
                    step.text = t;
                }
                steps[i] = step;
            }
        }

        int count = 0;
        for (Step s : steps) {
            count++;
            System.out.println(count + " " + s.text);
        }
        return steps;
    }
    private String Category(Document doc1) throws IOException {
        Elements text2 = doc1.getElementsByClass("cat_razd");
        String cat = text2.text();

        return cat;
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

    public String GetMainImg(Document doc1){
        Elements meta = doc1.select("meta[property=og:image]");
        String path_img = "";
        for (Element s : meta) {
            path_img = s.attr("content");
        }
        return path_img;
    }
}
