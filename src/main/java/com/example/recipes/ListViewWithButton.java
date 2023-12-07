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

public class ListViewWithButton extends Application {

    @Override
    public void start(Stage primaryStage) {

        ListView<String> listView = new ListView<>();
        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ButtonListCell();
            }
        });

        listView.getItems().addAll(Data.all_recipe);

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class ButtonListCell extends ListCell<String> {
        private final Button button;
        Stage stage;
        Scene scene;

        public ButtonListCell() {
            button = new Button("Посмотреть");
            button.setOnAction(event -> {
                String item = getItem();
                if (item != null) {

                    Parent root = null;
                    try {
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