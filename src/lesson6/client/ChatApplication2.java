package lesson6.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatApplication2 extends Application {

    private static final String CONNECTION_ERROR_MESSAGE = "CONNECTION ERROR MESSAGE";
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("chat-view.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load);
        this.stage.setTitle("chat GeekBrains");
        this.stage.setScene(scene);
        ChatController controller = fxmlLoader.getController();

        controller.userList.getItems().addAll("User1", "User2");
        stage.show();

        connectToServer(controller);
    }

    private void connectToServer(ChatController chatController) {
        Network network = new Network();
        boolean result = network.connect();
        if(!result)
        {
            System.err.println(CONNECTION_ERROR_MESSAGE);
            showErrorDialog(CONNECTION_ERROR_MESSAGE);
            return;
        }
        chatController.setNetwork(network);
        chatController.setApplication(this);
        this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                network.close();
            }
        });
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}