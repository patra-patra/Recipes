package com.example.recipes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewRecipeController implements Initializable {
    @FXML
    public Button ToMain;
    @FXML
    public Button AddProd;
    @FXML
    public Label Ingrediets;
    @FXML
    public Label wrn;
    @FXML
    public Button NewStep;
    @FXML
    public Button AddIngrToRec;
    @FXML
    private TextField Name;
    @FXML
    private TextField Weight;
    @FXML
    private TextField Category;
    @FXML
    private TextField Time;
    @FXML
    private TextField LinkToMainIMG;
    @FXML
    private ListView NewSteps;
    @FXML
    private ListView Ingredients;
    @FXML
    private ComboBox Difflevel;
    @FXML
    private ComboBox Prod2;
    Stage stage;
    Scene scene;
    Recipe NewOne;
    String[] arr2;
    List<Product> all_prod;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ingredients.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell("Удалить");
            }
        });

        NewSteps.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell("Посмотреть");
            }
        });

        Name.setText(Data.current_recipe.name);
        Category.setText(Data.current_recipe.category);
        Time.setText(Data.current_recipe.time);
        LinkToMainIMG.setText(Data.current_recipe.main_img);

        if (Data.current_recipe.steps != null){
            String[] arr = new String[Data.current_recipe.steps.size()];
            int count;

            for (int i = 0; i < Data.current_recipe.steps.size(); i++) {
                count = i + 1;
                arr[i] = "Шаг " + count + ": " + Data.current_recipe.steps.get(i).text;
            }
            NewSteps.getItems().addAll(arr);

            arr2 = new String[Data.current_recipe.ingredients.size()];

            for (int i = 0; i < Data.current_recipe.ingredients.size(); i++) {
                arr2[i] = Data.current_recipe.ingredients.get(i).temp_weight + " г " + Data.current_recipe.ingredients.get(i).name;
            }
            Ingredients.getItems().addAll(arr2);

            String warning = "Не добавлены:\n";

            for (int i = 0; i < Data.ingredients_from_pars.size(); i++){
                warning += Data.ingredients_from_pars.get(i) + "\n";
            }
            Ingrediets.setText(warning);

            Name.setText(Data.current_recipe.name);
            Category.setText(Data.current_recipe.category);
            Time.setText(Data.current_recipe.time);
            LinkToMainIMG.setText(Data.current_recipe.main_img);

            all_prod = Database.showAllProducts();
            List<String> all_prod_for_inrf = new ArrayList<>();

            for (int i = 0; i < all_prod.size(); i++) {
                all_prod_for_inrf.add(all_prod.get(i).name);
            }

            System.out.println(all_prod);

            Prod2.setItems(FXCollections.observableArrayList(all_prod_for_inrf));
            Difflevel.setItems(FXCollections.observableArrayList("Легкий", "Средний", "Сложный"));
        }
    }

    public void Input(ActionEvent event) throws IOException {
        NewOne = new Recipe();

        NewOne.name = Name.getText();
        NewOne.time = Time.getText();
        NewOne.main_img = LinkToMainIMG.getText();
        NewOne.category = Category.getText();
        NewOne.difficulty_level = Difflevel.getValue().toString();

        if (Data.all_recipe.contains(Data.current_recipe.name)){
            Data.current_recipe.name = Name.getText();
            Data.current_recipe.time = Time.getText();
            Data.current_recipe.main_img = LinkToMainIMG.getText();
            Data.current_recipe.category = Category.getText();
            Data.current_recipe.difficulty_level = Difflevel.getValue().toString();

            List<Step> temp = Database.showSteps(Data.current_recipe.id);

            for (Step step: temp) {
                Database.deleteImgs(step.step_id);
            }

            Database.deleteSteps(Data.current_recipe.id);
            Database.deleteProductsFromRec(Data.current_recipe.id);

            for (Step step: Data.current_recipe.steps) {
                Database.addStep(Data.current_recipe.id, step.text);
            }

            List<Step> steps = Database.showSteps(Data.current_recipe.id);

            for (Step step: Data.current_recipe.steps) {
                if (step.img != null){
                    for (Step step_get: steps){
                        if (Objects.equals(step_get.text, step.text)){
                            Database.addStepImg(step_get.step_id, step.img.get(0));
                        }
                    }
                }
            }

            for (Product product: Data.current_recipe.ingredients) {
                Database.addProductToRecipe(product.id, Data.current_recipe.id, product.temp_weight);
            }

            Database.updateRecipe(Data.current_recipe);
        }
        else {
            if (NewOne.name != null && NewOne.time != null && NewOne.main_img != null && NewOne.category != null && NewOne.difficulty_level != null){
                Database.addRecipe(NewOne);

                NewOne.id = Database.searchRecipe(NewOne.name).id;

                for (Step step: Data.current_recipe.steps) {
                    Database.addStep(NewOne.id, step.text);
                }

                List<Step> steps = Database.showSteps(NewOne.id);

                for (Step step: Data.current_recipe.steps) {
                    if (step.img != null){
                        for (Step step_get: steps){
                            if (Objects.equals(step_get.text, step.text)){
                                Database.addStepImg(step_get.step_id, step.img.get(0));
                            }
                        }
                    }
                }

                for (Product product: Data.current_recipe.ingredients) {
                    Database.addProductToRecipe(product.id, NewOne.id, product.temp_weight);
                }
                Data.all_recipe.add(Data.current_recipe.name);
            }
        }
        System.out.println(Data.current_recipe.ingredients);
        Data.current_recipe = null;

        SwitchToMain(event);
    }

    public void SwitchToCreateProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("new_product.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainpage_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }
    public void NewStep(ActionEvent event) throws IOException {
        Data.current_recipe.name = Name.getText();
        Data.current_recipe.difficulty_level = Difflevel.getValue().toString();
        Data.current_recipe.time = Time.getText();
        Data.current_recipe.main_img = LinkToMainIMG.getText();
        Data.current_recipe.category = Category.getText();

        Parent root = FXMLLoader.load(getClass().getResource("add_step.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }

    public void AddIngr(ActionEvent event) throws IOException {
        Data.current_recipe.name = Name.getText();

        Product pr = new Product();
        pr.temp_weight =  Double.valueOf(Weight.getText());
        pr.name = Prod2.getValue().toString();


        for (Product product: all_prod){
            if(Objects.equals(product.name, pr.name)){
                pr.id = product.id;
                Data.current_recipe.ingredients.add(pr);
            }
        }

        arr2 = new String[Data.current_recipe.ingredients.size()];

        for (int i = 0; i < Data.current_recipe.ingredients.size(); i++)
            arr2[i] = Data.current_recipe.ingredients.get(i).temp_weight + " г " + Data.current_recipe.ingredients.get(i).name;

        Ingredients.getItems().clear();
        Ingredients.getItems().addAll(arr2);
    }
}
