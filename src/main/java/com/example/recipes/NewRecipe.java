package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewRecipe implements Initializable {
    @FXML
    public Button ToMain;
    @FXML
    public Button AddIgr;
    @FXML
    public Label Ingrediets;
    @FXML
    public Button AddStep;
    @FXML
    private TextField Name;
    @FXML
    private TextField Category;
    @FXML
    private TextField Time;
    @FXML
    private TextField LinkToMainIMG;
    @FXML
    private TextField Difflevel;
    @FXML
    private ListView NewSteps;
    @FXML
    private ListView Ingredients;
    Stage stage;
    Scene scene;
    Recipe NewOne;


    public void initialize(URL url, ResourceBundle resourceBundle) {


        Ingredients.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Name.setText(Data.current_recipe.name);
        Category.setText(Data.current_recipe.category);
        Time.setText(Data.current_recipe.time);
        LinkToMainIMG.setText(Data.current_recipe.main_img);

        if (Data.current_recipe.steps != null){
            String[] arr = new String[Data.current_recipe.steps.size()];

            for (int i = 0; i < Data.current_recipe.steps.size(); i++)
                arr[i] = Data.current_recipe.steps.get(i).text;

            NewSteps.getItems().addAll(arr);
            String[] arr2 = new String[Data.current_recipe.ingredients.size()];

            for (int i = 0; i < Data.current_recipe.ingredients.size(); i++)
                arr2[i] = Data.current_recipe.ingredients.get(i).temp_weight + " г " + Data.current_recipe.ingredients.get(i).name;

            Ingredients.getItems().addAll(arr2);

            String warning = "Не добавлены:\n";

            for (int i = 0; i < Data.ingredients_from_pars.size(); i++){
                warning += Data.ingredients_from_pars.get(i) + "\n";
            }
            Ingrediets.setText(warning);


            Name.setText(Data.current_recipe.name);
            Category.setText(Data.current_recipe.category);
            Time.setText(Data.current_recipe.time);
            LinkToMainIMG.setText(Data.current_recipe.main_img);
        }

    }

    public void Input(ActionEvent event) throws IOException {

        NewOne = new Recipe();

        NewOne.name = Name.getText();
        NewOne.time = Time.getText();
        NewOne.main_img = LinkToMainIMG.getText();
        NewOne.category = Category.getText();
        NewOne.difficulty_level = Difflevel.getText();

        if (NewOne.name != null && NewOne.time != null && NewOne.main_img != null && NewOne.category != null && NewOne.difficulty_level != null){
            Database.addRecipe(NewOne);

            NewOne.id = Database.searchRecipe(NewOne.name).id;

            for (Step step: Data.current_recipe.steps) {
                Database.addStep(NewOne.id, step.text);
            }

            List<Step> steps = Database.showSteps(NewOne.id);


            for (Step step: Data.current_recipe.steps) {
                if (step.img != null){
                    for (Step step_get: steps){
                        if (Objects.equals(step_get.text, step.text)){
                            Database.addStepImg(step_get.step_id, step.img.get(0));
                        }
                    }
                }
            }

            for (Product product: Data.current_recipe.ingredients) {
                Database.addProductToRecipe(product.id, NewOne.id, product.temp_weight);
            }


            Data.all_recipe.add(Data.current_recipe.name);
            Data.current_recipe = null;

            SwitchToMain(event);
        }
    }

    private void SwitchToCreateProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_product.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchToMain(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
    public void NewStep(ActionEvent event) throws IOException {

        Data.current_recipe.name = Name.getText();
        Data.current_recipe.difficulty_level = Difflevel.getText();
        Data.current_recipe.time = Time.getText();
        Data.current_recipe.main_img = LinkToMainIMG.getText();
        Data.current_recipe.category = Category.getText();

        Parent root = FXMLLoader.load(getClass().getResource("add_step.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
    public void NewProd(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("new_exist_product.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
}
