package com.example.recipes;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MainPageSceneController implements Initializable {
    @FXML
    public Button ToCart;
    @FXML
    private VBox Cat;
    @FXML
    private VBox Time;
    @FXML
    private VBox Difficulity;
    @FXML
    public CheckBox SortAlph;
    @FXML
    public CheckBox Fav;
    @FXML
    public CheckBox All;
    @FXML
    public CheckBox FromNewToOld;
    @FXML
    public CheckBox FromOldToNew;
    @FXML
    private ListView<String> myList;
    @FXML
    private Button ParsButton;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Data.all_recipe = Data.Get();
        String[] arr = new String[Data.all_recipe.size()];
        List<Recipe> t = Database.showAllRecipe();

        for (int i = 0; i < Data.all_recipe.size(); i++) {
            arr[i] = t.get(i).name;
        }

        try {
            Cat(url, resourceBundle);
            Time(url, resourceBundle);
            Difficulity(url, resourceBundle);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        myList.getItems().addAll(arr);
    }

    public void initialize() {
        myList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListViewWithButton.ButtonListCell();
            }
        });

        Data.all_recipe = Data.Get();
        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {
            arr[i] = Data.all_recipe.get(i);
        }

        myList.getItems().clear();
        myList.getItems().addAll(arr);
    }

    public void Change(ActionEvent event) throws IOException{
        if (FromNewToOld.isSelected()){
            FromNewToOld(event);


            //SortAlph.isSelected() = false;
                    /*
            @FXML
            public CheckBox Fav;
            @FXML
            public CheckBox All;
            @FXML
            public CheckBox FromNewToOld;
            @FXML
            public CheckBox FromOldToNew;*/


        }
        else{
            initialize();
        }
    }
    public void Change_2(ActionEvent event) throws IOException{
        if (SortAlph.isSelected()){
            SortByAlph(event);
        }
        else{
            initialize();
        }
    }
    public void Change_3(ActionEvent event) throws IOException{
        if (FromOldToNew.isSelected()){
            initialize();
        }
        else{
            initialize();
        }
    }
    public void Change_4(ActionEvent event) throws IOException{
        if (Fav.isSelected()){
            Fav2(event);
        }
        else{
            initialize();
        }
    }
    public void Change_5(ActionEvent event) throws IOException{
        if (All.isSelected()){
            initialize();
        }
        else{
            initialize();
        }
    }

    public void SortByAlph(ActionEvent event) throws IOException {

        Data.all_recipe = Data.Get();

        List<Recipe> t = Database.showAllRecipe();
        Collections.sort(t, new CompByName());

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < Data.all_recipe.size(); i++) {

            arr[i] = t.get(i).name;

        }

        myList.getItems().clear();
        myList.getItems().addAll(arr);
    }
    public void SortByCat(String cat) throws IOException {

        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        List<String> category = new ArrayList<>();

        String[] arr = new String[t.size()]; // массив с категориями

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).category;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set); // массив с категориями без повторов

        List<String> names_by_category = new ArrayList<>();

        for (int i = 0; i < t.size(); i++) {
            if (Objects.equals(t.get(i).category, cat)){
                names_by_category.add(t.get(i).name);
            }
        }
        String[] fin_filtration = new String[names_by_category.size()];

        for (int i = 0; i < names_by_category.size(); i++) {

            fin_filtration[i] = names_by_category.get(i);
        }

        myList.getItems().clear();
        myList.getItems().addAll(fin_filtration);
    }
    public void SortByTime(String cat) throws IOException {

        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        List<String> time = new ArrayList<>();

        String[] arr = new String[t.size()]; // массив с категориями

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).time;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set); // массив с категориями без повторов

        List<String> names_by_category = new ArrayList<>();

        for (int i = 0; i < t.size(); i++) {

            if (Objects.equals(t.get(i).time, cat)) {
                names_by_category.add(t.get(i).name);
            }
        }

        String[] fin_filtration = new String[names_by_category.size()];

        for (int i = 0; i < names_by_category.size(); i++) {

            fin_filtration[i] = names_by_category.get(i);
        }

        myList.getItems().clear();
        myList.getItems().addAll(fin_filtration);
    }
    public void SortByDif(String cat) throws IOException {

        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        List<String> time = new ArrayList<>();

        String[] arr = new String[t.size()]; // массив с категориями

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).difficulty_level;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set);


        List<String> names_by_category = new ArrayList<>();

        for (int i = 0; i < t.size(); i++) {

            if (Objects.equals(t.get(i).difficulty_level, cat)){
                names_by_category.add(t.get(i).name);
            }
        }

        String[] fin_filtration = new String[names_by_category.size()];

        for (int i = 0; i < names_by_category.size(); i++) {

            fin_filtration[i] = names_by_category.get(i);
        }

        myList.getItems().clear();
        myList.getItems().addAll(fin_filtration);
    }
    public void FromNewToOld(ActionEvent event) throws IOException {
        Data.all_recipe = Data.Get();

        List<Recipe> t = Database.showAllRecipe();
        Collections.reverse(t);

        String[] arr = new String[Data.all_recipe.size()];

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).name;
        }

        myList.getItems().clear();
        myList.getItems().addAll(arr);
    }
    public void Fav2(ActionEvent event) throws IOException {
        List<Recipe> t = Database.showRecipeFavorite();

        String[] arr = new String[t.size()];

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).name;
        }

        myList.getItems().clear();
        myList.getItems().addAll(arr);
    }
    public void Cat(URL url, ResourceBundle resourceBundle) throws IOException {
        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        String[] arr = new String[t.size()];

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).category;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set);

        for (String cat: id_){
            CheckBox checkBox = new CheckBox(cat);
            checkBox.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        try {
                            SortByCat(cat);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            Cat.getChildren().add(checkBox);
        }
    }

   public void Time(URL url, ResourceBundle resourceBundle) throws IOException {
        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        String[] arr = new String[t.size()];

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).time;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set);

        for (String cat: id_){

            CheckBox checkBox = new CheckBox(cat);
            checkBox.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        try {
                            SortByTime(cat);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            Time.getChildren().add(checkBox);
        }
    }
 public void Difficulity(URL url, ResourceBundle resourceBundle) throws IOException {
        Data.all_recipe = Data.Get();
        List<Recipe> t = Database.showAllRecipe();

        String[] arr = new String[t.size()];

        for (int i = 0; i < t.size(); i++) {
            arr[i] = t.get(i).difficulty_level;
        }

        List<String> id_ =  new ArrayList<>(Arrays.asList(arr));
        Set<String> set = new HashSet<>(id_);
        id_.clear();
        id_.addAll(set);

        for (String cat: id_){
            CheckBox checkBox = new CheckBox(cat);
            checkBox.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        try {
                            SortByDif(cat);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            Difficulity.getChildren().add(checkBox);
        }
    }

    public void SwitchToCart (ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("cart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToNew (ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("new_recipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToPars (ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("recipe_pars.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root2);
        stage.setScene(scene);
        stage.show();
    }

}
