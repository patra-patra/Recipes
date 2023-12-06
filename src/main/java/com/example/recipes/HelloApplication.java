package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.GenericArrayType;
import java.net.URL;
import java.util.Objects;

public class HelloApplication extends Application {

    Button button;
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Recipes");

        Parent root = FXMLLoader.load(getClass().getResource("recipe_scene.fxml"));

        Scene scene = new Scene(root);

        Image icon = new Image("kitty.jpg");
        stage.getIcons().add(icon);

        //stage.setWidth(500);
       // stage.setHeight(500);

        //stage.setResizable(false);

        stage.setScene(scene);
        stage.show();

    }

    public static void main( String[] args ) throws IOException{
        launch(args);
    }
}