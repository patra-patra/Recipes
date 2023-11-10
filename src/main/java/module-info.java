module com.example.recipes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.recipes to javafx.fxml;
    exports com.example.recipes;
}