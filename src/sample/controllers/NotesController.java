package sample.controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.data.DataSource;
import sample.data.Note;

import java.util.Set;

public class NotesController {
    @FXML
    public Button BackToMenu;

    @FXML
    public ListView List;

    @FXML
    public TextField searchWord;

    @FXML
    public TextField searchTag;

    @FXML
    public CheckBox checkBox;

    public void initialize() {
        loadItems();
    }

    public void loadItems(){
        for(Note note : DataSource.getInstance().getAllNotes()){
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

    public void handleSearch(KeyEvent e){
        String word = searchWord.getText();
        String tag = searchTag.getText();
        Boolean check = CheckBox.getClassCssMetaData().isEmpty();
        List.getItems().clear();

        if(!word.isEmpty() && !tag.isEmpty()){
            for(Note note : DataSource.getInstance().getNotesByAllParameters(word,tag,check)){
                List.getItems().add(note.getTitle() + "\nDescription: " + note.getContent());
            }
        }else if(!word.isEmpty()){
            for(Note note : DataSource.getInstance().getNotesByWord(word)){
                List.getItems().add(note.getTitle() + "\nDescription: " + note.getContent());
            }
        }

        if(List.getItems().isEmpty()){
            List.getItems().add("No items found.");
        }
    }

}
