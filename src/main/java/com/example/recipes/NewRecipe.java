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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewRecipe implements Initializable {
    @FXML
    public Button ToMain;
    @FXML
    public Button AddIgr;
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
    @FXML
    private Label Warning;
    @FXML
    private ImageView WarningImg;
    Recipe NewOne = new Recipe();


    public void initialize(URL url, ResourceBundle resourceBundle) {

        Name.setText(Data.current_recipe.name);
        Category.setText(Data.current_recipe.category);
        Time.setText(Data.current_recipe.time);
        LinkToMainIMG.setText(Data.current_recipe.main_img);

        if (Data.current_recipe.steps != null){
            String[] arr = new String[Data.current_recipe.steps.size()];

            for (int i = 0; i < Data.current_recipe.steps.size(); i++)
                arr[i] = Data.current_recipe.steps.get(i).text;

            NewSteps.getItems().addAll(arr);

            String[] arr2 = new String[Data.current_recipe.ingrgredients.size()];

            for (int i = 0; i < Data.current_recipe.ingrgredients.size(); i++)
                arr2[i] = Data.current_recipe.ingrgredients.get(i);

            Ingredients.getItems().addAll(arr2);

            Name.setText(Data.current_recipe.name);
            Category.setText(Data.current_recipe.category);
            Time.setText(Data.current_recipe.time);
            LinkToMainIMG.setText(Data.current_recipe.main_img);
        }



    }

    public void Input(ActionEvent event){
        NewOne.name = Name.getText();
        NewOne.time = Time.getText();
        NewOne.main_img = LinkToMainIMG.getText();
        NewOne.category = Category.getText();
        NewOne.difficulty_level = Difflevel.getText();

        if (NewOne.name != null && NewOne.time != null && NewOne.main_img != null && NewOne.category != null && NewOne.difficulty_level != null){
            Database.addRecipe(NewOne.name, NewOne.category, NewOne.main_img, NewOne.time, NewOne.difficulty_level, 0);

            NewOne.id = Database.searchRecipe(NewOne.name).id;

            for (Step step: Data.current_recipe.steps) {
                Database.addStep(NewOne.id, step.text);
            }

            for (Step step: Data.current_recipe.steps) {
                Database.addStep(NewOne.id, step.text);
            }

            Data.all_recipe.add(Data.current_recipe.name);

            Data.current_recipe = null;
        }
    }


    public void SwitchToMain(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
    public void NewStep(ActionEvent event) throws IOException {

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
