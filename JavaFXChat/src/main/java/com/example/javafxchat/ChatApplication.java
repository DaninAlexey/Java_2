package com.example.javafxchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("chat-view.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load);
        stage.setTitle("chat GeekBrains");
        stage.setScene(scene);
        ChatController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("User1", "User2");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}