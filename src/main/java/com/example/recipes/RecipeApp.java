package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeApp extends Application {

    public void start(Stage stage) throws IOException {
        Data data = new Data();

        stage.setTitle("Recipes");

        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("kitty.jpg");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    public static void main( String[] args ) throws IOException{
        launch(args);
    }
}