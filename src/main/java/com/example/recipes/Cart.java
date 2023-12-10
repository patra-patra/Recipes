package com.example.recipes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Cart implements Initializable {

    @FXML
    private ListView<String> myCart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Data.shopping_bag = Database.showCart();

        String[] arr = new String[Data.shopping_bag.size()];

        for (int i = 0; i < Data.shopping_bag.size(); i++) {
            arr[i] = Data.shopping_bag.get(i).name;

        }
        myCart.getItems().addAll(arr);
    }

    public void SwitchToMain(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }

}
