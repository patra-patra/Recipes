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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public Button ToCart;

    @FXML
    public Button Date;

    @FXML
    public ImageView MainPageIMG;
    @FXML
    private ListView<String> myList;

    @FXML
    private Button ParsButton;

    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Data.all_recipe = Data.Get();

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {
            //arr[i] = Data.all_recipe.get(i);
            arr[i] = Data.all_recipe.get(i);
        }

        myList.getItems().addAll(arr);

    }

    public void initialize() {

        myList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Data.all_recipe = Data.Get();

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {
            //arr[i] = Data.all_recipe.get(i);
            arr[i] = Data.all_recipe.get(i);
        }

        myList.getItems().clear();
        myList.getItems().addAll(arr);

    }

    public void SortByAlph(ActionEvent event) throws IOException {

        Data.all_recipe = Data.Get();

        List<Recipe> t = Database.showAllRecipe();
        Collections.sort(t, new CompByName());

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {

            arr[i] = t.get(i).name;
            System.out.println(arr[i]);
        }
        myList.getItems().clear();
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
