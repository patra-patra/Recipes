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

public class NewExistProduct implements Initializable {
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


    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void Input(ActionEvent event) throws IOException {


        Product pr = Database.searchProduct(Name.getText());

        if (pr == null){
            SwitchToCreateProduct(event);
        }
        else{
            pr.temp_weight = Double.valueOf(Weight.getText());
            Data.current_recipe.ingredients.add(pr);

            //System.out.println(pr);



            Recipe r = new Recipe();
            Double[] d = r.Count_p_c_f_cl(Data.current_recipe.ingredients);

            for (Double dd: d){
                System.out.println(dd);
            }

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
