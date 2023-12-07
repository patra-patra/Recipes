package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewProduct {
    @FXML
    private TextField Protein;
    @FXML
    private TextField Carb;
    @FXML
    private TextField Fat;
    @FXML
    private TextField Name;
    @FXML
    private Button ToRec;
    @FXML
    private Stage stage;
    private Scene scene;
    public void SwitchToRec (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Input(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
