package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller{
    @FXML
    public Button CheckList;

    @FXML
    public Button CheckNotes;

    @FXML
    public Button NewNote;

    @FXML
    public Button Settings;

    @FXML
    void handleButtonCheckList(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/todo.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 700, 850));
            stage.show();
            Node source = (Node) e.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
        }catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    @FXML
    void handleButtonCheckNotes(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/notes.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 700, 850));
            stage.show();
            Node source = (Node) e.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
        }catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    @FXML
    void handleButtonNewNote(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/createNote.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 700, 850));
            stage.show();
            Node source = (Node) e.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
        }catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    @FXML
    void handleButtonSettings(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/settings.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 700, 850));
            stage.show();
            Node source = (Node) e.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
        }catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

}
