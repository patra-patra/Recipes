package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ParsSceneController {
    @FXML
    private TextField LinkToPars;
    @FXML
    public Button ToMain;
    @FXML
    public Button ParseNew;

    public void SwitchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }

    public void Input(ActionEvent event) throws IOException {
        Pars pars = new Pars();
        Data.current_recipe = pars.GetRecipe(LinkToPars.getText());
        Data.ingredients_from_pars = pars.Ingridients(LinkToPars.getText());

        SwitchToNewRecipe(event);
    }

    public void SwitchToNewRecipe(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
}
