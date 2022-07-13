package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {



    }


    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/firstStartWindow.fxml"));
        stage.setScene(new Scene(pane));
        stage.show();
    }
}
