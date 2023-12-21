package com.example.recipes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
                    Parent root = null;
                    switch (word){
                        case "Удалить":
                            for (int i = 0; i < Data.current_recipe.ingredients.size(); i++){
                                Product pr = Data.current_recipe.ingredients.get(i);

                                if (Objects.equals(pr.name, item.split(" г ")[1])){
                                    Data.current_recipe.ingredients.remove(pr);
                                }
                            }

                            try {
                                root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
                            }
                            catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);

                            stage.show();

                            break;
                        case "Удалить из корзины":
                            for (int i = 0; i < Data.shopping_bag.size(); i++){
                                Product pr = Data.shopping_bag.get(i);

                                if (Objects.equals(pr.name, item)){
                                    Data.shopping_bag.remove(pr);
                                    Database.deleteFromCart(pr.id);
                                }
                            }

                            try {
                                root = FXMLLoader.load(getClass().getResource("cart.fxml"));
                            }
                            catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);

                            stage.show();

                            break;
                        case "Посмотреть":

                            try {
                                root = FXMLLoader.load(getClass().getResource("add_step.fxml"));
                            }
                            catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);

                            stage.show();

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