package org.example.lab10_4;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Information Dialog");
        alert1.setHeaderText(null);
        alert1.setContentText("Here is some information!");
        alert1.showAndWait();

        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation Dialog");
        alert2.setHeaderText(null);
        alert2.setContentText("Are you sure?");
        Optional<ButtonType> result = alert2.showAndWait();
        if (result.get() == ButtonType.OK){
            // User chose OK
        } else {
            // User chose Cancel or closed the dialog
        }

        TextInputDialog dialog = new TextInputDialog("Default text");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your text:");
        Optional<String> result2 = dialog.showAndWait();
        if (result2.isPresent()){
            // User entered some text
        }

        List<String> choices = new ArrayList<>();
        choices.add("Option 1");
        choices.add("Option 2");
        choices.add("Option 3");
        ChoiceDialog<String> dialog2 = new ChoiceDialog<>("Default option", choices);
        dialog2.setTitle("Choice Dialog");
        dialog2.setHeaderText(null);
        dialog2.setContentText("Choose your option:");
        Optional<String> result3 = dialog.showAndWait();
        if (result3.isPresent()){
            // User chose an option
        }
    }
}