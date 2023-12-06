package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewRecipe {

    @FXML
    private TextField Name;

    @FXML
    private TextField Time;

    private Parent root;

    Recipe NewOne = new Recipe();

    public void Input(ActionEvent event){
        NewOne.name = Name.getText();
        NewOne.time = Time.getText();
        System.out.println(NewOne.name);
        System.out.println(NewOne.time);

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
