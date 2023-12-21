package com.example.recipes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ListViewWithButton {

    public static class ButtonListCell extends ListCell<String> {
        private final Button button;
        Stage stage;
        Scene scene;
        String item;

        public  ButtonListCell() {
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
        public ButtonListCell(String word) {
            button = new Button(word);
            button.setOnAction(event -> {
                item = getItem();
                if (item != null) {
                    switch (word){
                        case "Удалить":
                            for (int i = 0; i < Data.current_recipe.ingredients.size(); i++){
                                Product pr = Data.current_recipe.ingredients.get(i);
                                Data.current_recipe.ingredients.remove(pr);

                            }
                            break;
                        case "Удалить из корзины":
                            for (int i = 0; i < Data.shopping_bag.size(); i++){
                                Product pr = Data.shopping_bag.get(i);

                                if (Objects.equals(pr.name, item)){
                                    Data.shopping_bag.remove(pr);
                                    Database.deleteFromCart(pr.id);
                                }

                            }
                            break;
                        default:
                            break;
                    }
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