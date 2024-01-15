package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddStepController implements Initializable {
    @FXML
    private TextField Text;
    @FXML
    private Button Input;
    @FXML
    private Button DeleteStep;
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
    ArrayList<String> img;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Links.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell("Удалить ссылку");
            }
        });

        img = Data.selected_step.img;

        Text.setText(Data.selected_step.text);
        Links.getItems().addAll(img);
    }
    public void initialize() {
        Links.getItems().addAll(img);
    }
    public void Input(ActionEvent event) throws IOException {
        NewStep.text = Text.getText();
        NewStep.img = img;

        Data.current_recipe.steps.add(NewStep);

        ToMain(event);
    }

    public void DelStep(ActionEvent event) throws IOException {
        for (int i = 0; i < Data.current_recipe.steps.size(); i++){
            Step step = Data.current_recipe.steps.get(i);

            if (Objects.equals(step.text, Text.getText())){
                Data.current_recipe.steps.remove(step);
            }
        }
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
    public void Quit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
}
