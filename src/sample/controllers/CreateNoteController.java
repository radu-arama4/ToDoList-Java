package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.Main;
import sample.data.DataSource;
import sample.data.Note;

public class CreateNoteController {
    @FXML
    public Button BackToMenu;

    @FXML
    public TextArea Title;

    @FXML
    public TextArea Content;

    @FXML
    public TextArea Tag;

    @FXML
    public DatePicker Reminder;

    @FXML
    public CheckBox ToList;

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

    private void checkContent(){

    }

    //String title, String tags, String reminder, String list, String content

    public void handleSubmitButton(ActionEvent e){
        System.out.println("Submited: " + Title.getText() + " " + Content.getText() + " "
                + Tag.getText() + !ToList.getTypeSelector().isEmpty());
        String toList = null;
        if(!ToList.getTypeSelector().isEmpty()){
            toList = "true";
        }
        DataSource.getInstance().insertNote(new Note(Title.getText(),
                Tag.getText(), "reminder", toList, Content.getText()));
    }

}
