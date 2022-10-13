package org.chess4j.destop;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chess4jDestop extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Chess4j");

        Parent root = FXMLLoader.load(Chess4jDestop.class.getResource("WhiteView.fxml"));
        primaryStage.setScene(new Scene(root, 1000, 1000));

        primaryStage.show();
    }
}
