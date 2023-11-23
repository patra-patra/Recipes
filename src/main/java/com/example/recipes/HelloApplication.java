package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HelloApplication extends Application {


    Button button;
    @Override
    public void start(Stage stage) throws IOException {

        /*
        stage.setTitle("Recipes");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);

        stage.getScene();
        stage.show();
*/

        stage.setTitle("Recipes");

        Group root = new Group();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);

        Image icon = new Image("kitty.jpg");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();


    }

    public static void main( String[] args ) throws IOException{
        launch(args);
        /*

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