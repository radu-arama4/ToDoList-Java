package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.DataSource;

public class Main extends Application {

    static private Stage primStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ToDo list");
        primaryStage.setScene(new Scene(root, 700, 850));
        primaryStage.show();
        primStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage returnPrimary(){
        return primStage;
    }

    @Override
    public void init() throws Exception {
        super.init();
        DataSource.getInstance().init();
    }
}
