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


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
/*
* function createRandomString(sumString){
const symbolArr = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
var randomString = "";
for (let i=0; i<sumString; i++){
	var index = Math.floor(Math.random()*symbolArr.length);
	randomString +=symbolArr[index];
}
return randomString;
}

console.log(createRandomString(10));
*
*
* */
    public static void main( String[] args ) throws IOException{

        String file = "111111"+".jpg";
        Pars pars = new Pars();
        String path = "https://saechka.ru/recipes/recipe_4445";
        //https://saechka.ru/
        //pars.NameRecipe(path);
        //pars.Time(path);
        //pars.Nutrition(path);
        //pars.Ingridients(path);
        pars.Steps(path);
        //pars.Category(path);



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