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

public class NewExistProductController {
    @FXML
    private TextField Name;
    @FXML
    private TextField Weight;
    @FXML
    private Button Add;
    @FXML
    private Button ToRec;

    Stage stage;
    Scene scene;

    public void Input(ActionEvent event) throws IOException {


        Product pr = Database.searchProduct(Name.getText());

        if (pr == null){
            SwitchToCreateProduct(event);
        }
        else{
            pr.temp_weight = Double.valueOf(Weight.getText());
            Data.current_recipe.ingredients.add(pr);

            SwitchToNewRec(event);
        }
    }
    public void SwitchToCreateProduct (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_product.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToNewRec (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
