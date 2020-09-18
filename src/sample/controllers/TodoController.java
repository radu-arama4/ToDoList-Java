package sample.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.Controller;
import javafx.scene.control.Button;
import sample.Main;
import sample.data.DataSource;
import sample.data.Note;

import javax.xml.crypto.Data;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.Main.*;

public class TodoController {

    @FXML
    public Button BackToMenu;

    @FXML
    public ListView<String> List;

    private ArrayList<Note> notes;

    public void initialize() {
        loadItems();
    }

    public void loadItems(){
        for(Note note : DataSource.getInstance().loadToDoList()){
            List.getItems().add(note.getTitle() + "\nDescription: " + note.getContent());
        }
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

    public void handleAddNewItem(ActionEvent e){
        System.out.println("Pressed");
    }

}
