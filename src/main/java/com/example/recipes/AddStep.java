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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddStep implements Initializable {
    @FXML
    private TextField Text;
    @FXML
    private Button Input;
    @FXML
    private Button Quit;
    @FXML
    private Button AddPicture;
    @FXML
    private TextField AddLink;
    @FXML
    private ListView<String> Links;

    Stage stage;
    Scene scene;
    Step NewStep = new Step();
    ArrayList<String> img = new ArrayList<>();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Links.getItems().addAll(img);
    }
    public void initialize() {
        Links.getItems().addAll(img);
    }
    public void Input(ActionEvent event) throws IOException {

        NewStep.text = Text.getText();
        NewStep.img = img;

        Data.current_recipe.steps.add(NewStep);

        //Data.AddToTempSteps(NewStep);

        ToMain(event);
    }

    public void ToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddToLinks(ActionEvent event){
        String temp = AddLink.getText();
        img.add(temp);
        Links.getItems().clear();

        initialize();
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
    public void Quit(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("main_step.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }

}
