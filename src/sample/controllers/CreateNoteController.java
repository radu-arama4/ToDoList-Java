package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

public class CreateNoteController {
    @FXML
    public Button BackToMenu;

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
}
