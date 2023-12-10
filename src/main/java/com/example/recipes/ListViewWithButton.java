package com.example.recipes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewWithButton {

    public static class ButtonListCell extends ListCell<String> {
        private final Button button;
        Stage stage;
        Scene scene;
        String item;

        public  ButtonListCell() {

            //String item;
            button = new Button("Посмотреть");
            button.setOnAction(event -> {
                item = getItem();
                if (item != null) {

                    Parent root = null;
                    try {
                        Data.current_recipe = Database.searchRecipe(item);
                        root = FXMLLoader.load(getClass().getResource("recipe_scene.fxml"));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);

                    stage.show();

                }
            });


        }
        public  ButtonListCell(String word) {

            //String item;
            button = new Button(word);
            button.setOnAction(event -> {
                item = getItem();
                if (item != null) {
                    Parent root = null;
                    try {
                        Data.current_recipe = Database.searchRecipe(item);
                        root = FXMLLoader.load(getClass().getResource("recipe_scene.fxml"));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);

                    stage.show();

                }
            });


        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item);
                setGraphic(button);
            }
        }


    }

}