package com.example.newestdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primarystage.initStyle(StageStyle.UNDECORATED);
        //primarystage.setTitle("Hello World");
        primarystage.setScene(new Scene(root, 520, 400));
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}