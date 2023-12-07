package com.example.recipes;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

public class ButtonListCell extends ListCell<String> {/*
    private final Button button;

    public ButtonListCell() {
        button = new Button("Посмотреть");
        button.setOnAction(event -> {
            String item = getItem();
            if (item != null) {
                //System.out.println("Button clicked for: " + item);

            }
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item);
            setGraphic(button);
        }
    }*/
}
