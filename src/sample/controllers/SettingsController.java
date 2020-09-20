package sample.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

public class SettingsController {
    @FXML
    public Button BackToMenu;

    @FXML
    public TextField Name;

    @FXML
    public ChoiceBox Storage;

    public void initialize() {
        Storage.setItems(FXCollections.observableArrayList("DataBase", "Text File"));
    }


    public void handleBackToMenu(ActionEvent e){
        try{
            Node source = (Node) e.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.hide();
            Main.returnPrimary().show();
        }catch (Exception f){
            System.out.println("Error - " + f.getMessage());
        }
    }

    public void handleSave(ActionEvent e){
        System.out.println("Selected Name - " + Name.getText());
        System.out.println("Storage configuration - " + Storage.getValue().toString());
    }

}
