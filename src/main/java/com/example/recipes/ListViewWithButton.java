package com.example.recipes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

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

        public ButtonListCell() {
            button = new Button("Посмотреть");
            button.setOnAction(event -> {
                String item = getItem();
                if (item != null) {
                    //System.out.println("Button clicked for: " + item);

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
/*
    public static void main(String[] args) {
        launch(args);
    }
*/
    // Custom ListCell with a button

}