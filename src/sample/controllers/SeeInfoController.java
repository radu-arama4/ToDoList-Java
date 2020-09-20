package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import sample.Controller;
import sample.data.Note;

import java.awt.*;

public class SeeInfoController {

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

    public void initialize(Note item) {
        //System.out.println("Got it - " +item.getTitle());
        Title.setText(item.getTitle());
        Content.setText(item.getContent());
        Tag.setText(item.getTags());
        ToList.setSelected(true);
    }

    //User will be able to edit here the note
    public void handleTitle(){

    }

    public void handleContent(){

    }

    public void handleTag(){

    }

    public void handleReminder(){

    }

    public void handleToList(){

    }

}
