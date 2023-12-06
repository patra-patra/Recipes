package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button ToCart;
    @FXML
    private ListView<String> myList;
    @FXML
    private Button NewOne;

    private Stage stage;
    private Scene scene;
    private Parent root;
    String[] food = {"a", "b", "c"};
    String current;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myList.getItems().addAll(food);
    }

    public void SwitchToRec(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("recipe_scene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToCart (ActionEvent event) throws IOException {

        Parent root2 = FXMLLoader.load(getClass().getResource("cart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();

    }
    public void SwitchToNew (ActionEvent event) throws IOException {

        Parent root2 = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();

    }

    public void getNewOne(ActionEvent event) {

    }
}
