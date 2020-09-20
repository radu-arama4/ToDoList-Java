package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import sample.Main;
import sample.data.DataSource;
import sample.data.Note;

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
    public BorderPane border;

    @FXML
    public CheckBox checkBox;

    @FXML
    public Button Details;

    @FXML
    public Button AddToList;

    @FXML
    public Button Delete;

    public Note selectedItemInfo;

    public void initialize() {
        loadItems();
        Delete.setDisable(true);
        Details.setDisable(true);
        AddToList.setDisable(true);
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

    public void handleSearch(Event e){
        String word = searchWord.getText();
        String tag = searchTag.getText();
        Boolean check = checkBox.selectedProperty().getValue();
        System.out.println(check);
        List.getItems().clear();

        for(Note note : DataSource.getInstance().getNotesByAllParameters(word,tag,check)){
            List.getItems().add(note.getTitle() + "\nDescription: " + note.getContent());
        }

        if(List.getItems().isEmpty()){
            List.getItems().add("No items found.");
        }
    }

    public void handleItem(MouseEvent e){
        System.out.println(List.getSelectionModel().getSelectedItems());
        Delete.setDisable(false);
        Details.setDisable(false);
        AddToList.setDisable(false);
    }

    public void handleSeeInfoButton(ActionEvent e){
        String note = List.getSelectionModel().getSelectedItems().toString();
        String name = note.substring(1,note.indexOf("Description:"));
        name = name.replaceAll("\\R+", "");
        this.selectedItemInfo = DataSource.getInstance().getNotesByWord(name);
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmlFiles/info.fxml"));
            Parent root1 = fxmlLoader.load();
            SeeInfoController controller = fxmlLoader.<SeeInfoController>getController();
            controller.initialize(selectedItemInfo);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 700, 850));
            stage.show();
        }catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    public void handleAddToList(ActionEvent e){
        String note = List.getSelectionModel().getSelectedItems().toString();
        String name = note.substring(1,note.indexOf("Description:"));
        name = name.replaceAll("\\R+", "");
        System.out.println("Added to list " + name);
        DataSource.getInstance().addNoteToList(name);
    }

    public void handleDeleteItem(ActionEvent e){
        String note = List.getSelectionModel().getSelectedItems().toString();
        String name = note.substring(1,note.indexOf("Description:"));
        name = name.replaceAll("\\R+", "");
        DataSource.getInstance().deleteNote(name);
        List.getItems().clear();
        initialize();
    }

}
