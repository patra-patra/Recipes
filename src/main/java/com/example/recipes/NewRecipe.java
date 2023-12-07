package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewRecipe implements Initializable {
    @FXML
    public Button ToMain;
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

    private Parent root;

    Recipe NewOne = new Recipe();


    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] arr = new String[Data.steps_from_new.size()];

        for (int i = 0; i < Data.steps_from_new.size(); i++)
            arr[i] = Data.steps_from_new.get(i).text;

        NewSteps.getItems().addAll(arr);


        if (Data.current_recipe != null){

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

        Database.addRecipe(NewOne.name, NewOne.category, NewOne.main_img, NewOne.time, NewOne.difficulty_level, 0);
        Data.current_recipe = null;
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
}
