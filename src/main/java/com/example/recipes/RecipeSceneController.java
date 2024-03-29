package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeSceneController implements Initializable {
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
    public Button Update;
    @FXML
    public Button ToFav;
    @FXML
    public Button AddToCart;
    @FXML
    public ImageView CurrentRecipeIMG;
    @FXML
    public VBox Steps;
    @FXML
    public VBox Ingred;
    private Stage stage;
    private Scene scene;
    private Image img;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setText(Data.current_recipe.name);
        Time.setText(Data.current_recipe.time);
        Category.setText(Data.current_recipe.category);
        Difficult.setText(Data.current_recipe.difficulty_level);

        Data.current_recipe.ingredients = Database.showProducts(Data.current_recipe.id);
        Data.current_recipe.steps = Database.showSteps(Data.current_recipe.id);

        for (Step step: Data.current_recipe.steps) {
            Data.current_recipe_img.addAll(Database.showStepImg(step.step_id));
        }

        img = new Image(Data.current_recipe.main_img);
        CurrentRecipeIMG.setImage(img);

        Double[] measures = Data.current_recipe.Count_p_c_f_cl(Data.current_recipe.ingredients);

        Calories.setText(String.format("%.2f",measures[3]));
        Fat.setText(String.format("%.2f",measures[2]));
        Protein.setText(String.format("%.2f",measures[0]));
        Carb.setText(String.format("%.2f", measures[1]));

        Ingred.setPadding(new Insets(10, 5, 10, 5));
        Ingred.setSpacing(Data.current_recipe.ingredients.size());

        for (int i = 0; i < Data.current_recipe.ingredients.size(); i++){

            Double weight = Database.showWeight(Data.current_recipe.id, Database.searchProduct(Data.current_recipe.ingredients.get(i).name).id);
            Label ing = new Label(Data.current_recipe.ingredients.get(i).name + " - " + weight + " г");
            Ingred.getChildren().add(ing);
        }

        Steps.setPadding(new Insets(10, 5, 10, 5));
        Steps.setSpacing(2);

        for (int i = 0; i < Data.current_recipe.steps.size(); i++){

            int st = i + 1;
            Label step = new Label("Шаг "+ st +": "+ Data.current_recipe.steps.get(i).text);
            Steps.getChildren().add(step);

                for (Step_img imgg: Data.current_recipe_img){
                    HBox box = new HBox();
                    if (imgg.step_id == Data.current_recipe.steps.get(i).step_id) {
                        ImageView img_step = new ImageView();
                        img = new Image(imgg.img_url);

                        img_step.setFitHeight(100);
                        img_step.setFitWidth(100);

                        img_step.setImage(img);
                        box.getChildren().add(img_step);
                    }
                    Steps.getChildren().add(box);
                }
            }
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
    public void Update(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void AddToCart(ActionEvent event) throws IOException {
        Data.shopping_bag.addAll(Data.current_recipe.ingredients);
        Database.addRecipeToCart(Data.current_recipe.id);
    }
    public void AddToFav(ActionEvent event) throws IOException {
       Database.addRecipeToFavorite(Data.current_recipe.id);
    }
}

