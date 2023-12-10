package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public Label Protein;
    @FXML
    public Label Carb;
    @FXML
    public Label Fat;
    @FXML
    public Label Calories;
    @FXML
    public Label Name;
    @FXML
    public Label Time;
    @FXML
    public Label Category;
    @FXML
    public Label Difficult;
    @FXML
    public Button Delete;
    @FXML
    public Button ToFav;
    @FXML
    public Button ToCart;
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

        Data.current_recipe.ingredients = Database.showProducts(Data.current_recipe.id);

        img = new Image(Data.current_recipe.main_img);
        CurrentRecipeIMG.setImage(img);


        for (Product ss : Data.current_recipe.ingredients) {
            System.out.println(ss);
        }


        Double[] measures = Data.current_recipe.Count_p_c_f_cl(Data.current_recipe.ingredients);


        Calories.setText(measures[3].toString());
        Fat.setText(measures[2].toString());
        Protein.setText(measures[0].toString());
        Carb.setText(measures[1].toString());

    }

    public void SwitchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Delete(ActionEvent event) throws IOException {
        Database.deleteRecipe(Data.current_recipe.id);
    }

    public void AddToCart(ActionEvent event) throws IOException {
        Data.shopping_bag.addAll(Data.current_recipe.ingredients);
    }


}

