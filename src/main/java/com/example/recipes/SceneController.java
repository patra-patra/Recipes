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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    @FXML
    public Label Name;
    @FXML
    public Label Time;
    @FXML
    public Label Category;
    @FXML
    public Label Difficult;
    @FXML
    public ImageView CurrentRecipeIMG;


    private Stage stage;
    private Scene scene;
    private Image img;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setText(Data.current_recipe.name);
        Time.setText(Data.current_recipe.time);
        Category.setText(Data.current_recipe.category);
        Difficult.setText(Data.current_recipe.difficulty_level);

        img = new Image(Data.current_recipe.main_img);
        CurrentRecipeIMG.setImage(img);

        //String[] arr = new String[Data.current_recipe.steps.size()];


    }
    public void SwitchToMain (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }




}
