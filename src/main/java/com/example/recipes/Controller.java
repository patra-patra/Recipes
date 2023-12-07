package com.example.recipes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public Button ToCart;
    @FXML
    private ListView<String> myList;
    @FXML
    private Label name;
    @FXML
    private Button ParsButton;
    @FXML
    private Stage stage;
    private Scene scene;
    String current;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ListView<String> listView = new ListView<>();
        myList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Data.all_recipe = Data.Get();

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {
            arr[i] = Data.all_recipe.get(i);
        }

        myList.getItems().addAll(arr);

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
    public void SwitchToPars (ActionEvent event) throws IOException {

        Parent root2 = FXMLLoader.load(getClass().getResource("recipe_pars.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();

    }

}
